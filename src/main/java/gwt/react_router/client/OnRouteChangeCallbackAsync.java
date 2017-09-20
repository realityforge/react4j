package gwt.react_router.client;

import gwt.react.client.util.JsProcedure;
import jsinterop.annotations.JsFunction;

@JsFunction
public interface OnRouteChangeCallbackAsync {
    void onChange(String prevState, String nextState, JsProcedure replaceFn, JsProcedure continueFn);
}
