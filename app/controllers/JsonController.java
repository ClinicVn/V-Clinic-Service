package controllers;

import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.databind.node.ObjectNode;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

/**
 * Abstract class for creating JSON-based controllers.
 *
 *
 */
public abstract class JsonController extends Controller {
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static Result ok(Object data) {
        return ok(OBJECT_MAPPER.valueToTree(data));
    }

    public static Result notFound(Long id) {
        ObjectNode output = Json.newObject();
        output.put("status", Http.Status.NOT_FOUND);
        output.put("error", "No object with gid = [" + id + "] found.");

        return notFound(output);
    }

    public static Result blogicError(String errorMessage) {
        ObjectNode output = Json.newObject();
        output.put("status", Http.Status.EXPECTATION_FAILED);
        output.put("error", errorMessage);

        return status(Http.Status.EXPECTATION_FAILED,output);
    }

    public static Result badRequest(String message) {
        ObjectNode output = Json.newObject();
        output.put("status", Http.Status.BAD_REQUEST);
        output.put("error", message);

        return badRequest(output);
    }

    public static Result internalServerErrors() {
        ObjectNode output = Json.newObject();
        output.put("status", Http.Status.INTERNAL_SERVER_ERROR);
        output.put("error", "Internal server error.");

        return internalServerError(output);
    }


    /* public static Result jsonResult(Result httpResponse) {
        response().setContentType("application/json; charset=utf-8");
        return httpResponse;
    }*/
}
