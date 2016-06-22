/**
 *
 */
package common;

/**
 * @author DungVST
 *
 */
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionCreator implements play.http.ActionCreator {
    final static Logger logger = LoggerFactory.getLogger(ActionCreator.class);
    @Override
    public Action createAction(Http.Request request, Method actionMethod) {
        logger.info(request.uri());
        return new Action.Simple() {
            @Override
            public CompletionStage<Result> call(Http.Context ctx) {
                return delegate.call(ctx);
            }
        };
    }
}