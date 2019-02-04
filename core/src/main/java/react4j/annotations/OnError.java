package react4j.annotations;

import elemental2.core.JsError;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import react4j.ReactErrorInfo;

/**
 * Identifies the method that is called when a child component generates an error during rendering.
 * The method works like a catch block, but for components. If this method generates an error, then this
 * error will propagate to the closest OnError annotated method above it.
 *
 * <p>The method can have up to two optional parameters. One is of type {@link JsError} and indicates
 * the error that was thrown. The other parameter is of type {@link ReactErrorInfo} and it contains
 * information about the component stack during thrown error.</p>
 *
 * <p>The method must also conform to the following constraints:</p>
 * <ul>
 * <li>Must not be annotated with any other react4j annotation</li>
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
public @interface OnError
{
}