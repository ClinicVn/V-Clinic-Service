package common;

/**
 * @author DungVST
 *
 */

import play.http.HttpErrorHandler;
import play.mvc.*;
import play.mvc.Http.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class ErrorHandler implements HttpErrorHandler {
    final static Logger logger = LoggerFactory.getLogger(ErrorHandler.class);
    @Override
    public CompletionStage<Result> onClientError(RequestHeader request, int statusCode, String message) {
        return CompletableFuture.completedFuture(
            Results.status(statusCode, "A client error occurred: " + message)
                );
    }

    public CompletionStage<Result> onServerError(RequestHeader request, Throwable exception) {
        if(exception != null){
            logger.error("Server error occurred at: "+ request.uri() + "\tExceptions: "+exception.getMessage());
        }
        return CompletableFuture.completedFuture(
            Results.internalServerError("A server error occurred: " + exception.getMessage())
                );
    }
}