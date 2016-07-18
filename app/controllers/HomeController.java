package controllers;

import java.util.List;

import play.*;
import play.mvc.*;
import play.i18n.Messages;
import play.libs.Json;
import play.libs.Json.*;
import play.data.Form;
import play.db.jpa.*;
import services.Md0002UserService;
import models.*;
import views.html.*;

import com.fasterxml.jackson.databind.node.ObjectNode;

//@Security.Authenticated(Secured.class)
public class HomeController extends Controller {


    public Result index() {
        ctx().changeLang("vn");
        String welcomeMsg = Messages.get("home.welcome");
        return ok(index.render(welcomeMsg));
    }
}
