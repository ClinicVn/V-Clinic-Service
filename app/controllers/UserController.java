package controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.*;
import play.mvc.*;
import play.libs.Json;
import play.libs.Json.*;
import play.data.Form;
import play.db.jpa.*;
import services.UserService;
import models.*;
import views.html.*;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Api(value = "/Users")
public class UserController extends Controller {
    static Form<User> userForm = Form.form(User.class);
    final static Logger logger = LoggerFactory.getLogger(UserController.class);
    public static User globleUser = new User();

    @ApiOperation(
        value = "List all users",
        notes = "Details for implementation")

    @Transactional(readOnly = true)
    public Result list(Integer page, Integer size) {
        List models = UserService.paginate(page-1, size);
        Long count = UserService.count();

        ObjectNode result = Json.newObject();
        result.put("data", Json.toJson(models));
        result.put("total", count);
        if (page > 1) {
            result.put("link-prev", routes.UserController.list(page-1, size).toString());
        }
        if (page*size < count) {
            result.put("link-next", routes.UserController.list(page+1, size).toString());
        }
        result.put("link-self", routes.UserController.list(page, size).toString());

        return JsonController.jsonResult(ok(result));
    }

    /**
     * Get one user by id
     *
     * @param Integer id
     *
     * @return Result
     */
    @Security.Authenticated(Secured.class)
    @Transactional(readOnly = true)
    public Result get(Integer id) {
        User user = UserService.find(id);
        if (user == null ) {
            ObjectNode result = Json.newObject();
            result.put("error", "Not found " + id);
            return JsonController.jsonResult(notFound(result));
        }
        return JsonController.jsonResult(ok(Json.toJson(user)));
    }

    /**
     * Create an user with the data of request
     *
     * @return Result
     */
    @Transactional
    public Result create() {
        Form<User> user = userForm.bindFromRequest();
        if (user.hasErrors()) {
            return JsonController.jsonResult(badRequest(user.errorsAsJson()));
        }
        User newUser = UserService.create(user.get());
        return JsonController.jsonResult(created(Json.toJson(newUser)));
    }

    /**
     * Update an user with the data of request
     *
     * @return Result
     */
    @Transactional
    public Result update() {
        Form<User> user = userForm.bindFromRequest();
        if (user.hasErrors()) {
            return JsonController.jsonResult(badRequest(user.errorsAsJson()));
        }
        User updatedUser = UserService.update(user.get());
        return JsonController.jsonResult(ok(Json.toJson(updatedUser)));
    }

    /**
     * Delete an user by id
     *
     * @param Integer id
     *
     * @return Result
     */
    @Transactional
    public Result delete(Integer id) {
        if (UserService.delete(id)) {
            ObjectNode result = Json.newObject();
            result.put("msg", "Deleted " + id);
            return JsonController.jsonResult(ok(result));
        }
        ObjectNode result = Json.newObject();
        result.put("error", "Not found " + id);
        return JsonController.jsonResult(notFound(result));
    }

    @Transactional(readOnly = true)
    public static Result findUserByToken(String token) {
        User user = UserService.findByAuthToken(token);
        if (user == null ) {
            return null;
        }
        return (Result) user;
    }
}
