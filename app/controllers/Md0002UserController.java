package controllers;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.*;
import play.mvc.*;
import play.i18n.Messages;
import play.libs.Json;
import play.libs.Json.*;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.*;
import services.CoreServices;
import services.Md0002UserService;
import models.*;
import views.html.*;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;

@Security.Authenticated(Secured.class)
public class Md0002UserController extends Controller {
    @Inject
    FormFactory formFactory;
    final static Logger logger = LoggerFactory.getLogger(Md0002UserController.class);

    @Transactional(readOnly = true)
    public Result list(Integer page, Integer size) {
        List models = Md0002UserService.paginate(page-1, size);
        Long count = Md0002UserService.count();

        ObjectNode result = Json.newObject();
        result.put("data", Json.toJson(models));
        result.put("total", count);
        if (page > 1) {
            result.put("link-prev", routes.Md0002UserController.list(page-1, size).toString());
        }
        if (page*size < count) {
            result.put("link-next", routes.Md0002UserController.list(page+1, size).toString());
        }
        result.put("link-self", routes.Md0002UserController.list(page, size).toString());

        return JsonController.jsonResult(ok(result));
    }

    /**
     * Get one user by id
     *
     * @param Integer id
     *
     * @return Result
     */
    @Transactional(readOnly = true)
    public Result get(Long id) {
        Md0002User user = Md0002UserService.find(id);
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
        Form<Md0002User> user = formFactory.form(Md0002User.class).bindFromRequest();
        if (user.hasErrors()) {
            return JsonController.jsonResult(badRequest(user.errorsAsJson()));
        }

        // Check exist
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("userCode", user.get().getUserCode());

        if(CoreServices.findByFields(Md0002User.class, params).size() > 0){
            ObjectNode result = Json.newObject();
            result.put("error", "User code [" + user.get().getUserCode()+ "] existed.");
            return JsonController.jsonResult(notFound(result));
        }

        Md0002User newUser = Md0002UserService.create(user.get());
        return JsonController.jsonResult(created(Json.toJson(newUser)));
    }

    /**
     * Update an user with the data of request
     *
     * @return Result
     */
    @Transactional
    public Result update() {
        Form<Md0002User> user = formFactory.form(Md0002User.class).bindFromRequest();
        if (user.hasErrors()) {
            return JsonController.jsonResult(badRequest(user.errorsAsJson()));
        }


        Md0002User inputUser = user.get();
        if(inputUser.getGid() == null){
            ObjectNode result = Json.newObject();
            result.put("error", "User [gid] is required.");
            return JsonController.jsonResult(notFound(result));
        }

        // Check exist
        Md0002User existingUser = Md0002UserService.find(inputUser.getGid());
        if(existingUser == null){
            ObjectNode result = Json.newObject();
            result.put("error", "User does not exist.");
            return JsonController.jsonResult(notFound(result));
        }

        // Ignore fields
        inputUser.setUserPwd(existingUser.getUserPwd());
        inputUser.setUserCode(existingUser.getUserCode());

        Md0002User updatedUser = Md0002UserService.update(inputUser);
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
    public Result delete(Long id) {
        if (Md0002UserService.delete(id)) {
            ObjectNode result = Json.newObject();
            result.put("msg", Messages.get("user.info.delete.success",id));
            return JsonController.jsonResult(ok(result));
        }
        ObjectNode result = Json.newObject();
        result.put("error",Messages.get("user.error.delete.notFound",id));
        return JsonController.jsonResult(notFound(result));
    }
}
