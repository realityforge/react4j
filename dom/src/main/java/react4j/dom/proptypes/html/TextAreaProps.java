package react4j.dom.proptypes.html;

import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import react4j.dom.events.DragEventHandler;
import react4j.dom.events.FocusEventHandler;
import react4j.dom.events.FormEventHandler;
import react4j.dom.events.KeyboardEventHandler;
import react4j.dom.events.MouseEventHandler;
import react4j.dom.events.TouchEventHandler;
import react4j.dom.proptypes.html.attributeTypes.OnOff;

/**
 * Props for input elements. Refer to https://developer.mozilla.org/en-US/docs/Web/HTML/Element/textarea
 */
@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Object" )
public class TextAreaProps
  extends HtmlGlobalFields<TextAreaProps>
{
  @JsOverlay
  public final TextAreaProps autoComplete( OnOff s )
  {
    setAutoComplete( s.name() );
    return self();
  }

  @JsOverlay
  public final TextAreaProps autoFocus( boolean b )
  {
    setAutoFocus( b );
    return self();
  }

  @JsOverlay
  public final TextAreaProps cols( int b )
  {
    setCols( b );
    return self();
  }

  @JsOverlay
  public final TextAreaProps disabled( boolean b )
  {
    setDisabled( b );
    return self();
  }

  @JsOverlay
  public final TextAreaProps form( String s )
  {
    setForm( s );
    return self();
  }

  @JsOverlay
  public final TextAreaProps maxLength( int l )
  {
    setMaxLength( l );
    return self();
  }

  @JsOverlay
  public final TextAreaProps minLength( int l )
  {
    setMinLength( l );
    return self();
  }

  @JsOverlay
  public final TextAreaProps name( String s )
  {
    setName( s );
    return self();
  }

  @JsOverlay
  public final TextAreaProps placeHolder( String s )
  {
    setPlaceholder( s );
    return self();
  }

  @JsOverlay
  public final TextAreaProps readonly( boolean b )
  {
    setReadOnly( b );
    return self();
  }

  @JsOverlay
  public final TextAreaProps required( boolean b )
  {
    setRequired( b );
    return self();
  }

  @JsOverlay
  public final TextAreaProps rows( int l )
  {
    setRows( l );
    return self();
  }

  @JsOverlay
  public final TextAreaProps value( String s )
  {
    setValue( s );
    return self();
  }

  //React Specific

  @JsOverlay
  public final TextAreaProps defaultValue( String s )
  {
    setDefaultValue( s );
    return self();
  }

  //Applicable Event Handlers

  // Focus Events
  @JsOverlay
  public final TextAreaProps onBlur( @Nullable final FocusEventHandler handler )
  {
    setOnBlur( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onFocus( @Nullable final FocusEventHandler handler )
  {
    setOnFocus( handler );
    return self();
  }

  // Form Events
  @JsOverlay
  public final TextAreaProps onChange( @Nullable final FormEventHandler handler )
  {
    setOnChange( handler );
    return self();
  }

  // Keyboard Events
  @JsOverlay
  public final TextAreaProps onKeyDown( @Nullable final KeyboardEventHandler handler )
  {
    setOnKeyDown( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onKeyPress( @Nullable final KeyboardEventHandler handler )
  {
    setOnKeyPress( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onKeyUp( @Nullable final KeyboardEventHandler handler )
  {
    setOnKeyUp( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onClick( @Nullable final MouseEventHandler handler )
  {
    setOnClick( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onContextMenu( @Nullable final MouseEventHandler handler )
  {
    setOnContextMenu( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onDoubleClick( @Nullable final MouseEventHandler handler )
  {
    setOnDoubleClick( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onDrag( @Nullable final DragEventHandler handler )
  {
    setOnDrag( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onDragEnd( @Nullable final DragEventHandler handler )
  {
    setOnDragEnd( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onDragEnter( @Nullable final DragEventHandler handler )
  {
    setOnDragEnter( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onDragExit( @Nullable final DragEventHandler handler )
  {
    setOnDragExit( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onDragLeave( @Nullable final DragEventHandler handler )
  {
    setOnDragLeave( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onDragOver( @Nullable final DragEventHandler handler )
  {
    setOnDragOver( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onDragStart( @Nullable final DragEventHandler handler )
  {
    setOnDragStart( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onDrop( @Nullable final DragEventHandler handler )
  {
    setOnDrop( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onMouseDown( @Nullable final MouseEventHandler handler )
  {
    setOnMouseDown( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onMouseEnter( @Nullable final MouseEventHandler handler )
  {
    setOnMouseEnter( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onMouseLeave( @Nullable final MouseEventHandler handler )
  {
    setOnMouseLeave( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onMouseMove( @Nullable final MouseEventHandler handler )
  {
    setOnMouseMove( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onMouseOut( @Nullable final MouseEventHandler handler )
  {
    setOnMouseOut( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onMouseOver( @Nullable final MouseEventHandler handler )
  {
    setOnMouseOver( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onMouseUp( @Nullable final MouseEventHandler handler )
  {
    setOnMouseUp( handler );
    return self();
  }

  // Touch Events
  @JsOverlay
  public final TextAreaProps onTouchCancel( @Nullable final TouchEventHandler handler )
  {
    setOnTouchCancel( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onTouchEnd( @Nullable final TouchEventHandler handler )
  {
    setOnTouchEnd( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onTouchMove( @Nullable final TouchEventHandler handler )
  {
    setOnTouchMove( handler );
    return self();
  }

  @JsOverlay
  public final TextAreaProps onTouchStart( @Nullable final TouchEventHandler handler )
  {
    setOnTouchStart( handler );
    return self();
  }
}
