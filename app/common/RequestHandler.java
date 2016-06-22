package common;

/**
 * @author DungVST
 *
 */
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.routing.Router;
import play.api.mvc.Handler;
import play.http.*;
import play.mvc.*;
import play.libs.streams.Accumulator;

public class RequestHandler implements HttpRequestHandler {
    private final Router router;

    @Inject
    public RequestHandler(Router router) {
        this.router = router;
    }

    @Override
    public HandlerForRequest handlerForRequest(Http.RequestHeader request) {
        Handler handler = router.route(request).orElseGet(() ->
        EssentialAction.of(req -> Accumulator.done(Results.notFound()))
                );
        return new HandlerForRequest(request, handler);
    }
}