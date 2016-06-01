package controllers;

import java.util.List;

import play.*;
import play.mvc.*;
import play.libs.Json;
import play.libs.Json.*;
import play.data.Form;
import play.db.jpa.*;
import services.EmployeeService;
import services.UserService;
import models.*;
import views.html.*;

import com.fasterxml.jackson.databind.node.ObjectNode;

//@Security.Authenticated(Secured.class)
public class HomeController extends Controller {


    public Result index() {
        return ok(index.render("Welcome to V-Clinic services"));
    }
}
