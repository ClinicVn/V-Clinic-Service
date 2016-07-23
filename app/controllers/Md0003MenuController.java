package controllers;

import java.math.BigInteger;
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
import services.Md0003MenuService;
import models.*;
import views.html.*;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;

@Security.Authenticated(Secured.class)
public class Md0003MenuController extends Controller {
    @Inject
    FormFactory formFactory;
    final static Logger logger = LoggerFactory.getLogger(Md0003MenuController.class);

    @Transactional(readOnly = true)
    public Result list(Integer page, Integer size) {
        List models = Md0003MenuService.paginate(page-1, size);
        Long count = Md0003MenuService.count();

        ObjectNode result = Json.newObject();
        result.put("data", Json.toJson(models));
        result.put("total", count);
        if (page > 1) {
            result.put("link-prev", routes.Md0003MenuController.list(page-1, size).toString());
        }
        if (page*size < count) {
            result.put("link-next", routes.Md0003MenuController.list(page+1, size).toString());
        }
        result.put("link-self", routes.Md0003MenuController.list(page, size).toString());

        return JsonController.ok(result);
    }

    /**
     * Get one menu by id
     *
     * @param Integer id
     *
     * @return Result
     */
    @Transactional(readOnly = true)
    public Result get(Long id) {
        Md0003Menu menu = Md0003MenuService.find(id);
        if (menu == null ) {
            return JsonController.notFound(id);
        }
        return JsonController.ok(Json.toJson(menu));
    }

    /**
     * Create an menu with the data of request
     *
     * @return Result
     */
    @Transactional
    public Result create() {
        Form<Md0003Menu> menu = formFactory.form(Md0003Menu.class).bindFromRequest();
        if (menu.hasErrors()) {
            return JsonController.badRequest(menu.errorsAsJson());
        }
        Md0003Menu newUser = Md0003MenuService.create(menu.get());
        return JsonController.created(Json.toJson(newUser));
    }

    /**
     * Update an menu with the data of request
     *
     * @return Result
     */
    @Transactional
    public Result update() {
        Form<Md0003Menu> menu = formFactory.form(Md0003Menu.class).bindFromRequest();
        if (menu.hasErrors()) {
            return JsonController.badRequest(menu.errorsAsJson());
        }
        Md0003Menu updatedUser = Md0003MenuService.update(menu.get());
        return JsonController.ok(Json.toJson(updatedUser));
    }

    /**
     * Delete an menu by id
     *
     * @param Integer id
     *
     * @return Result
     */
    @Transactional
    public Result delete(Long id) {
        if (Md0003MenuService.delete(id)) {
            return JsonController.ok(Messages.get("menu.info.delete.success",id));
        }
        return JsonController.notFound(Messages.get("menu.error.delete.notFound",id));
    }
}
