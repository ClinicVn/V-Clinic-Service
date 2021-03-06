package controllers;


import java.util.HashMap;
import java.util.List;

import models.Md0002User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.data.Form;
import play.data.validation.Constraints;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import services.CoreServices;
import services.Md0002UserService;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class SecurityController extends Controller {
    final static Logger logger = LoggerFactory.getLogger(SecurityController.class);

    //    @Inject FormFactory formFactory;

    public final static String AUTH_TOKEN_HEADER = "X-AUTH-TOKEN";
    public static final String AUTH_TOKEN = "authToken";


    public static Md0002User getMd0002User() {
        return (Md0002User)Http.Context.current().args.get("user");
    }


    @Transactional
    public Result login() {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();

        if (loginForm.hasErrors()) {
            return badRequest(loginForm.errorsAsJson());
        }

        Login login = loginForm.get();
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("userCode", login.userCode);
        params.put("userPwd", Md0002UserService.getSha512(login.userPwd));
        List<Md0002User> user = CoreServices.findByFields(Md0002User.class, params);

        if (user.size() == 0) {
            return unauthorized();
        }
        else {
            String authToken = user.get(0).createToken();
            user.get(0).setAuthToken(authToken);
            Md0002UserService.update(user.get(0));

            ObjectNode authTokenJson = Json.newObject();
            authTokenJson.put(AUTH_TOKEN, authToken);
            return ok(authTokenJson);
        }
    }

    @Security.Authenticated(Secured.class)
    public Result logout() {
        response().discardCookie(AUTH_TOKEN);
        getMd0002User().deleteAuthToken();
        return redirect("/");
    }

    public static class Login {

        @Constraints.Required
        public String userCode;

        @Constraints.Required
        public String userPwd;

    }

}
