package react4j.arez;

import arez.Arez;
import arez.ArezContext;
import arez.Disposable;
import arez.Observer;
import arez.annotations.Action;
import arez.annotations.ComponentId;
import arez.annotations.ContextRef;
import arez.annotations.ObserverRef;
import arez.annotations.OnDepsChanged;
import arez.annotations.Priority;
import arez.annotations.Track;
import arez.spy.ObservableInfo;
import elemental2.core.JsObject;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import react4j.Component;
import react4j.Procedure;
import react4j.ReactNode;
import static org.realityforge.braincheck.Guards.*;

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
public abstract class ReactArezComponent
  extends Component
{
  /**
   * Key used to store the arez data in state.
   */
  private static final String AREZ_STATE_KEY = "arez";
  private static int c_nextComponentId = 1;
  private final int _arezComponentId;
  private boolean _renderDepsChanged;
  private boolean _unmounted;

  protected ReactArezComponent()
  {
    _arezComponentId = c_nextComponentId++;
  }

  /**
   * Method invoked when props changes.
   *
   * @param nextProps the new properties of the component.
   */
  protected abstract void reportPropsChanged( @Nullable final JsPropertyMap<Object> nextProps );

  /**
   * {@inheritDoc}
   */
  @Override
  protected final void scheduleStateUpdate( @Nonnull final SetStateCallback callback,
                                            @Nullable final Procedure onStateUpdateComplete )
  {
    fail( () -> "Attempted to schedule state update on ReactArezComponent subclass. Use Arez @Observable or @Computed properties instead." );
  }

  /**
   * After construction of the object. Schedule any autoruns attached to component.
   */
  @Override
  protected final void performPostConstruct()
  {
    super.performPostConstruct();
    triggerScheduler();
  }

  /**
   * Template method overridden by annotation processor if there are autoruns to schedule.
   */
  protected void triggerScheduler()
  {
  }

  /**
   * Return true if the render dependencies have been marked as changed and component has yet to be re-rendered.
   *
   * @return true if render dependencies changed, false otherwise.
   */
  protected final boolean hasRenderDepsChanged()
  {
    return _renderDepsChanged;
  }

  /**
   * Hook used by Arez to notify component that it needs to be re-rendered.
   */
  @OnDepsChanged
  protected final void onRenderDepsChanged()
  {
    if ( !_renderDepsChanged )
    {
      _renderDepsChanged = true;
      if ( !_unmounted )
      {
        scheduleRender( true );
      }
    }
  }

  /**
   * Return the arez context that this component is associated with.
   * The component is associated with the context that was active when it was created
   * and can only react to observables associated with the same context.
   *
   * @return the arez context that this component is associated with.
   */
  @ContextRef
  @Nonnull
  protected abstract ArezContext getContext();

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

  /**
   * Return the Observer associated with the render tracker method.
   *
   * @return the Observer associated with the render tracker method.
   */
  @ObserverRef
  @Nonnull
  protected abstract Observer getRenderObserver();

  /**
   * {@inheritDoc}
   */
  @Override
  protected final ReactNode performRender()
  {
    return Disposable.isDisposed( this ) ? null : trackRender();
  }

  /**
   * Return true if any prop is an ArezComponent that has been disposed.
   * This is used to guard against rendering a react component that has invalid props.
   *
   * @return true if any prop is an ArezComponent that has been disposed.
   */
  protected boolean anyPropsDisposed()
  {
    return false;
  }

  /**
   * This method is the method enhanced by arez that performs render and tracks dependencies.
   * This SHOULD NOT be merged with {@link #performRender()} as then the isDisposed check will be present
   * in every instance of render method which can result in unnecessary code bloat.
   *
   * @return the result of rendering.
   */
  @Track( name = "render", priority = Priority.LOW )
  @Nullable
  protected ReactNode trackRender()
  {
    _renderDepsChanged = false;
    if ( anyPropsDisposed() )
    {
      return null;
    }
    else
    {
      final ReactNode result = super.performRender();
      if ( Arez.shouldCheckInvariants() && Arez.areSpiesEnabled() )
      {
        final List<ObservableInfo> dependencies = getContext().getSpy().getDependencies( getRenderObserver() );
        invariant( () -> !dependencies.isEmpty(),
                   () -> "ReactArezComponent render completed on '" + this + "' but the component does not " +
                         "have any Arez dependencies. This component should extend react4j.Component instead." );
      }
      return result;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean shouldComponentUpdate( @Nullable final JsPropertyMap<Object> nextProps,
                                           @Nullable final JsPropertyMap<Object> nextState )
  {
    if ( hasRenderDepsChanged() )
    {
      return true;
    }
    //noinspection SimplifiableIfStatement
    if ( !Js.isTripleEqual( super.state(), nextState ) )
    {
      // State is only updated when we store Arez data as state. The saving of arez data will actually
      // trigger a re-render and we need to allow this otherwise the DevTools will not contain the
      // updated state.
      return true;
    }
    else
    {
      /*
       * We just compare the props shallowly and avoid a re-render if the props have not changed.
       */
      final boolean modified = isObjectShallowModified( super.props(), nextProps );
      if ( modified )
      {
        reportPropsChanged( nextProps );
      }
      return modified;
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
  protected void componentDidUpdate( @Nullable final JsPropertyMap<Object> prevProps,
                                     @Nullable final JsPropertyMap<Object> prevState )
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
     * This method is overridden as it forces the annotation processor to generate the native
     * componentWillUnmount method. The native method is required so that performComponentWillUnmount()
     * is invoked and correctly cleans up state.
     */
  }

  /**
   * {@inheritDoc}
   */
  protected final void performComponentWillUnmount()
  {
    final Disposable schedulerLock = getContext().pauseScheduler();
    try
    {
      _unmounted = true;
      super.performComponentWillUnmount();
      /*
       * Dispose of all the arez resources. Necessary particularly for the render tracker that should
       * not receive notifications of updates after the component has been unmounted.
       */
      Disposable.dispose( this );
    }
    finally
    {
      schedulerLock.dispose();
    }
  }

  /**
   * Store arez data such as dependencies on the state of component.
   * This is only done if {@link ReactArezConfig#shouldStoreArezDataAsState()} returns true and is primarily
   * done to make it easy to debug from within React DevTools.
   */
  private void storeArezDataAsState()
  {
    if ( ReactArezConfig.shouldStoreArezDataAsState() && Arez.areSpiesEnabled() && !Disposable.isDisposed( this ) )
    {
      final Observer renderTracker = getRenderObserver();
      final List<ObservableInfo> dependencies = getContext().getSpy().getDependencies( renderTracker );
      final JsPropertyMap<Object> deps = JsPropertyMap.of();
      dependencies.forEach( d -> deps.set( d.getName(), getValue( d ) ) );
      final JsPropertyMap<Object> state = super.state();
      final Object currentDepsData = null != state ? Js.asPropertyMap( state ).get( AREZ_STATE_KEY ) : null;
      /*
       * Do a shallow comparison against object and the deps. If either has changed then state needs to be updated.
       * We skip deps on shallow comparison of data as it is always recreated anew.
       */
      if ( null == currentDepsData )
      {
        scheduleArezKeyUpdate( deps );
      }
      else
      {
        /*
         * Deps are mappings to Info objects that can be garbage collected over time.
         * So we just make sure the keys (which are the info objects names) match.
         */
        final String[] currentDeps = JsObject.keys( Js.uncheckedCast( currentDepsData ) );
        final String[] newDeps = JsObject.keys( Js.uncheckedCast( deps ) );
        if ( currentDeps.length != newDeps.length )
        {
          scheduleArezKeyUpdate( deps );
        }
        else
        {
          for ( int i = 0; i < currentDeps.length; i++ )
          {
            if ( !currentDeps[ i ].equals( newDeps[ i ] ) )
            {
              scheduleArezKeyUpdate( deps );
            }
          }
        }
      }
    }
  }

  /**
   * Return the value for specified observable.
   * Exceptions are caught and types are converted to strings using {@link Object#toString()}
   *
   * @param observableInfo the observable.
   * @return the value as a string.
   */
  @Nullable
  private Object getValue( @Nonnull final ObservableInfo observableInfo )
  {
    try
    {
      //Consider unwrapping the boxed values and collections so they are presented correctly in DevTools
      return Arez.arePropertyIntrospectorsEnabled() ? observableInfo.getValue() : "?";
    }
    catch ( final Throwable throwable )
    {
      return throwable;
    }
  }

  /**
   * Schedule state update the updates arez state.
   * Makes sure the super class is invoked so reportStateChanged() is not invoked on State observable.
   */
  private void scheduleArezKeyUpdate( @Nonnull final JsPropertyMap<Object> data )
  {
    super.scheduleStateUpdate( ( p, s ) -> Js.cast( JsPropertyMap.of( AREZ_STATE_KEY, JsObject.freeze( data ) ) ),
                               null );
  }

  /**
   * Return true if the two objects do not have identical keys and values. The method assumes that the two
   * objects passed are js objects and compares the objects have the same key-value.
   *
   * @param o1 the first object.
   * @param o2 the second object.
   * @return true if the two objects do not have identical keys and values.
   */
  private boolean isObjectShallowModified( @Nullable final JsPropertyMap<Object> o1,
                                           @Nullable final JsPropertyMap<Object> o2 )
  {
    if ( null == o1 || null == o2 || !Js.typeof( o1 ).equals( "object" ) || !Js.typeof( o2 ).equals( "object" ) )
    {
      return !Js.isTripleEqual( o1, o2 );
    }
    final String[] keys = JsObject.keys( Js.uncheckedCast( o1 ) );
    if ( JsObject.keys( Js.uncheckedCast( o2 ) ).length != keys.length )
    {
      return true;
    }
    for ( final String key : keys )
    {
      if ( !Js.isTripleEqual( o1.get( key ), o2.get( key ) ) )
      {
        return true;
      }
    }
    return false;
  }
}
