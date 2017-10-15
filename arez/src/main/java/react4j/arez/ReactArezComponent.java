package react4j.arez;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import jsinterop.base.JsPropertyMapOfAny;
import org.realityforge.arez.Arez;
import org.realityforge.arez.ArezContext;
import org.realityforge.arez.Observable;
import org.realityforge.arez.Observer;
import org.realityforge.arez.SafeFunction;
import org.realityforge.arez.annotations.Action;
import org.realityforge.arez.annotations.ComponentId;
import org.realityforge.arez.annotations.ComponentName;
import react4j.core.BaseProps;
import react4j.core.BaseState;
import react4j.core.Component;
import react4j.core.ReactElement;
import react4j.core.util.JsUtil;

/**
 * A base class for all Arez enabled components. This class makes the component
 * rendering reactive and it will schedule a re-render any time any of the observable
 * entities accessed within the scope of the render method are changed.
 *
 * <p>To achieve this goal, the props and state of the component are converted into
 * observable properties. This of course means they must be accessed within the scope
 * of an Arez transaction. (Typically this means it needs to be accessed within the
 * scope of a {@link Action} annotated method or within the scope of the render method.</p>
 */
public abstract class ReactArezComponent<P extends BaseProps, S extends BaseState>
  extends Component<P, S>
{
  /**
   * Key used to store the arez data in state.
   */
  private static final String AREZ_STATE_KEY = "arez";

  private static int c_nextComponentId = 1;
  private final int _arezComponentId;
  @Nonnull
  private final Observable _propsObservable;
  @Nonnull
  private final Observable _stateObservable;
  @Nonnull
  private final Observer _renderTracker;
  private boolean _renderDepsChanged;

  protected ReactArezComponent()
  {
    _arezComponentId = c_nextComponentId++;
    final ArezContext context = Arez.context();
    _propsObservable = context.createObservable( toName( ".props" ) );
    _stateObservable = context.createObservable( toName( ".state" ) );
    _renderTracker = context.tracker( toName( ".render" ), false, this::onRenderDepsChanged );
  }

  private void onRenderDepsChanged()
  {
    _renderDepsChanged = true;
    scheduleRender( false );
  }

  /**
   * Return the unique identifier of component according to Arez.
   * This method is invoked by the code generated by the Arez annotation processor.
   *
   * @return the unique identifier of component according to Arez.
   */
  @ComponentId
  protected final int getArezComponentId()
  {
    return _arezComponentId;
  }

  @Nullable
  private String toName( @Nonnull final String suffix )
  {
    return Arez.context().areNamesEnabled() ? getComponentName() + suffix : null;
  }

  /**
   * Return the name of the component according to Arez.
   * This method is overridden by the Arez annotation processor.
   * This method can be invoked by the user if they want to manually create more reactive components
   * (i.e. {@link Observable}s, {@link Action}s etc. However it ias highly recommended that the normal
   * annotation driven approach be used instead.
   *
   * @return the name of the component according to Arez.
   */
  @ComponentName
  protected String getComponentName()
  {
    // Arez will override this method so we can ignore the value here.
    return "<default>";
  }

  /**
   * Retrieve the component state.
   * This method must be called within the scope of an Arez transaction as
   * it will mark the state as "observed"
   *
   * @return the component state.
   */
  @Override
  protected final S state()
  {
    _stateObservable.reportObserved();
    return super.state();
  }

  /**
   * Retrieve the component props.
   * This method must be called within the scope of an Arez transaction as
   * it will mark the props as "observed"
   *
   * @return the component props.
   */
  @Override
  protected final P props()
  {
    _propsObservable.reportObserved();
    return super.props();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected final void setState( @Nonnull final S state )
  {
    Arez.context().safeAction( toName( ".setState" ),
                               true,
                               () -> {
                                 _stateObservable.reportChanged();
                                 super.setState( state );
                               } );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected final void setState( @Nonnull final SetStateCallback<P, S> callback )
  {
    super.setState( ( s, p ) ->
                      Arez.context().safeAction( toName( ".setStateCallback" ),
                                                 true,
                                                 () -> {
                                                   _stateObservable.reportChanged();
                                                   return callback.onSetState( s, p );
                                                 } ) );
  }

  @Nullable
  @Override
  protected ReactElement<?, ?> performRender()
  {
    _renderDepsChanged = false;
    /*
     * Need an uncheckedCast here rather than regular cast as otherwise GWT attempts to cast
     * this using a method that does not work. Unclear of the exact cause. Also need to extract
     * the function to a separate variable otherwise JDT failes to determine type.
     */
    final SafeFunction<ReactElement<?, ?>> render = this::render;
    return Js.uncheckedCast( Arez.context().safeTrack( _renderTracker, render ) );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean shouldComponentUpdate( @Nullable final P nextProps, @Nullable final S nextState )
  {
    if ( _renderDepsChanged )
    {
      return true;
    }
    //noinspection SimplifiableIfStatement
    if ( !Js.isTripleEqual( super.state(), nextState ) )
    {
      // If state is not identical then we need to re-render ...
      // Previously we chose not to re-render if only AREZ_STATE_KEY that was updated but that
      // meant deps in DevTools would not be update so now we just re-render anyway.
      return true;
    }
    else
    {
      /*
       * We just compare the props shallowly and avoid a re-render if the props have not changed.
       */
      return JsUtil.isObjectShallowModified( super.props(), nextProps );
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void componentDidMount()
  {
    storeArezDataAsState();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void componentDidUpdate( @Nullable final P prevProps, @Nullable final S prevState )
  {
    storeArezDataAsState();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void componentWillUnmount()
  {
    /*
     * Dispose of all the arez resources. Necessary particularly for render tracker that should
     * not receive notifications of updates are component has been unmounted.
     */
    _propsObservable.dispose();
    _stateObservable.dispose();
    _renderTracker.dispose();
  }

  /**
   * Store arez data such as dependencies on the state of component.
   * This is only done if {@link ReactArezConfig#shouldStoreArezDataAsState()} returns true and is primarily
   * done to make it easy to debug from within React DevTools.
   */
  private void storeArezDataAsState()
  {
    if ( ReactArezConfig.shouldStoreArezDataAsState() && Arez.context().areSpiesEnabled() )
    {
      final List<Observable> dependencies = Arez.context().getSpy().getDependencies( _renderTracker );
      final JsPropertyMapOfAny deps = JsPropertyMap.of();
      dependencies.forEach( d -> deps.set( d.getName(), d ) );
      final JsPropertyMapOfAny data = JsPropertyMap.of();
      data.set( "name", _renderTracker.getName() );
      data.set( "observer", _renderTracker );
      data.set( "deps", deps );
      final S state = super.state();
      final Object currentArezData = null != state ? JsPropertyMap.of( state ).get( AREZ_STATE_KEY ) : null;
      final Object currentDepsData = null != currentArezData ? JsPropertyMap.of( currentArezData ).get( "deps" ) : null;
      /*
       * Do a shallow comparison against object and the deps. If either has changed then state needs to be updated.
       * We skip deps on shallow comparison of data as it is always recreated anew.
       */
      if ( JsUtil.isObjectShallowModified( currentArezData, data, "deps" ) ||
           JsUtil.isObjectShallowModified( currentDepsData, deps ) )
      {
        super.setState( Js.<S>cast( JsPropertyMap.of( AREZ_STATE_KEY, data ) ) );
      }
    }
  }
}
