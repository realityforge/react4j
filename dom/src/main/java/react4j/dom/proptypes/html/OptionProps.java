package react4j.dom.proptypes.html;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Props for option elements. Refer to http://www.w3schools.com/tags/tag_option.asp
 */
@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Object" )
public class OptionProps
  extends HtmlGlobalFields<OptionProps>
{
  @JsOverlay
  public final OptionProps disabled( boolean b )
  {
    setDisabled( b );
    return self();
  }

  @JsOverlay
  public final OptionProps label( String s )
  {
    setLabel( s );
    return self();
  }

  @JsOverlay
  public final OptionProps selected( boolean b )
  {
    setSelected( b );
    return self();
  }

  @JsOverlay
  public final OptionProps value( String s )
  {
    setValue( s );
    return self();
  }
}
