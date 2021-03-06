package react4j.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Identifies a method that is called when the value of one of the specified inputs is changed.
 * Each parameter of the method is mapped to a input that is tracked. The method will be called
 * before or after the update has occurred and will be passed the previous values of the inputs
 * as parameters.
 *
 * <p>Each parameter is expected to be named according to the pattern "last[MyInput]", "prev[MyInput]"
 * or "[myInput]". If name of the parameter does not follow the pattern then the name can be explicitly
 * mapped via the {@link InputRef} annotation on a parameter.</p>
 *
 * <p>The method must also conform to the following constraints:</p>
 * <ul>
 * <li>Must not be annotated with any other react4j annotation</li>
 * <li>Must have 1 or more parameters. Each parameter must map to a input as described above.</li>
 * <li>Must not return a value</li>
 * <li>Must not be private</li>
 * <li>Must not be public</li>
 * <li>Must not be static</li>
 * <li>Must not be abstract</li>
 * <li>Must not throw exceptions</li>
 * <li>Must be accessible from the same package as the class annotated by {@link View}</li>
 * <li>
 *   Should not be public as not expected to be invoked outside the view. A warning will be generated but can
 *   be suppressed by the {@link SuppressWarnings} or {@link SuppressReact4jWarnings} annotations with a key
 *   "React4j:PublicMethod". This warning is also suppressed by the annotation processor if it is implementing
 *   an interface method.
 * </li>
 * <li>
 *   Should not be protected if in the class annotated with the {@link View} annotation as the method is not
 *   expected to be invoked outside the view. A warning will be generated but can be suppressed by the
 *   {@link SuppressWarnings} or {@link SuppressReact4jWarnings} annotations with a key "React4j:ProtectedMethod".
 * </li>
 * </ul>
 */
@Documented
@Target( ElementType.METHOD )
public @interface OnInputChange
{
  /**
   * Phase in which method should be invoked.
   */
  enum Phase
  {
    /**
     * Method should be invoked before update.
     */
    PRE,
    /**
     * Method should be invoked after update.
     */
    POST
  }

  /**
   * The phase in which the method should be invoked.
   *
   * @return the phase in which the method should be invoked.
   */
  Phase phase() default Phase.PRE;
}
