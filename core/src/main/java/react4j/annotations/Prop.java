package react4j.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import javax.annotation.Nonnull;
import jsinterop.base.JsPropertyMap;

/**
 * Annotation used to specify an abstract method that returns a prop.
 * The property is extracted from Reacts underlying props object.
 *
 * <p>The method that is annotated with <code>@Prop</code> must also comply with the following constraints:</p>
 * <ul>
 * <li>Must not be annotated with any other react annotation</li>
 * <li>Must have 0 parameters</li>
 * <li>Must return a value</li>
 * <li>Must be an abstract instance method</li>
 * <li>Must not throw exceptions</li>
 * <li>Must be accessible from the same package as the class annotated by {@link ReactComponent}</li>
 * </ul>
 */
@Documented
@Target( ElementType.METHOD )
public @interface Prop
{
  /**
   * Return the name of the prop.
   * If the underlying method conforms to java beans accessor conventions (i.e. starts with "is" and is a boolean
   * or starts with "get") then the name is the same as the java bean convention dictates, otherwise the name of
   * the method is used as the default value for the prop.
   *
   * @return the name of the prop.
   */
  @Nonnull
  String name() default "<default>";

  /**
   * Return enum indicating whether prop should be when component is constructed.
   * This influences validation when enabled and how the Builder class is created.
   * If set to {@link Feature#ENABLE} then the user MUST supply the prop and the builder will require the user
   * to specify the value. If set to {@link Feature#DISABLE} then the user can optionally supply the prop.
   * If set to {@link Feature#AUTODETECT} then the annotation processor will treat it as {@link Feature#DISABLE}
   * if there is a corresponding {@link PropDefault} for the prop, otherwise it will be treated as
   * {@link Feature#ENABLE}.
   *
   * @return the flag indicating whether the prop needs to be supplied.
   */
  Feature require() default Feature.AUTODETECT;

  /**
   * Return an enum indicating whether prop should trigger a change if it updated.
   * This setting is used when the annotation processors is responsible for implementing
   * the {@link react4j.Component#shouldComponentUpdate(JsPropertyMap, JsPropertyMap)} lifecycle
   * method. If set to {@link Feature#ENABLE} then the code will check the prop when implementing
   * <code>shouldComponentUpdate</code>. If set to {@link Feature#DISABLE} then the prop will be ignored
   * when implementing <code>shouldComponentUpdate</code>. If set to {@link Feature#AUTODETECT} then the
   * annotation processor will treat it as {@link Feature#ENABLE}.
   *
   * @return the enum indicating whether prop should trigger a change if it updated.
   */
  Feature shouldUpdateOnChange() default Feature.AUTODETECT;
}
