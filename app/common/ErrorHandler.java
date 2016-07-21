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
            Results.status(statusCode, "===CLIENT ERROR===\n" + message)
                );
    }

    public CompletionStage<Result> onServerError(RequestHeader request, Throwable exception) {
        if(exception != null){
            exception.printStackTrace();
            logger.error("===SERVER ERROR==="+" \nMessage: "+   exception.getMessage() +" \nCause: "+ exception.getCause().getCause());
        }
        return CompletableFuture.completedFuture(
            Results.internalServerError("===SERVER ERROR==="+" \nMessage: "+   exception.getMessage() +" \nCause: "+ exception.getCause().getCause())
                );
    }
}