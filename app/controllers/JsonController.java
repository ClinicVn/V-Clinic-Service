package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Abstract class for creating JSON-based controllers.
 *
 * 
 */
public abstract class JsonController extends Controller {
   /* protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static Status ok(Object data) {
        return ok(OBJECT_MAPPER.valueToTree(data));
    }

    public static Status notFound(int id) {
        ObjectNode output = Json.newObject();
        output.put("status", Http.Status.NOT_FOUND);
        output.put("message", "No object with id=" + id + " found.");

        return notFound(output);
    }

    public static Status badRequest(String message) {
        ObjectNode output = Json.newObject();
        output.put("status", Http.Status.BAD_REQUEST);
        output.put("message", message);

        return badRequest(output);
    }

    public static Status internalServerError() {
        ObjectNode output = Json.newObject();
        output.put("status", Http.Status.INTERNAL_SERVER_ERROR);
        output.put("message", "Internal server error.");

        return internalServerError(output);
    }*/
    

    /**
     * Add the content-type json to response
     *
     * @param Result httpResponse
     *
     * @return Result
     */
	
    public static Result jsonResult(Result httpResponse) {
        response().setContentType("application/json; charset=utf-8");
        return httpResponse;
    }
}
