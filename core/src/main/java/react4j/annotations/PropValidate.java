package react4j.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import javax.annotation.Nonnull;

/**
 * Identifies method that is called when the prop value is specified or changes.
 *
 * <p>The method must also conform to the following constraints:</p>
 * <ul>
 * <li>Must not be annotated with any other react4j annotation</li>
 * <li>Must have 1 parameter that matches the type of the prop</li>
 * <li>Must not return a value</li>
 * <li>Must not be private</li>
 * <li>Must not be public</li>
 * <li>Must not be static</li>
 * <li>Must not be abstract</li>
 * <li>Must not throw exceptions</li>
 * <li>Must be accessible from the same package as the class annotated by {@link ReactComponent}</li>
 * </ul>
 */
@Documented
@Target( ElementType.METHOD )
public @interface PropValidate
{
  /**
   * Return the name of the associated prop. If the value is not specified then the name
   * will be derived assuming that the method name matches the pattern "validate[Name]"
   *
   * @return the name of the prop.
   */
  @Nonnull
  String name() default "<default>";
}