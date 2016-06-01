package controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import models.User;

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
import services.UserService;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Api(value = "/Authentication")
public class SecurityController extends Controller {
    final static Logger logger = LoggerFactory.getLogger(SecurityController.class);

    //    @Inject FormFactory formFactory;

    public final static String AUTH_TOKEN_HEADER = "X-AUTH-TOKEN";
    public static final String AUTH_TOKEN = "authToken";


    public static User getUser() {
        return (User)Http.Context.current().args.get("user");
    }

    // returns an authToken
    @ApiOperation(
        value = "Login",
        notes = "After login must process the token")

    @ApiResponses(
        value = {
            @ApiResponse(code = 200, message = "Login successfully"),
            @ApiResponse(code = 401, message = "Login failure"),
            @ApiResponse(code = 500, message = "DB connection error")
        })

    @ApiImplicitParams(
        {
            @ApiImplicitParam(
                name = "user",
                dataType = "String",
                required = true,
                paramType = "String",
                value = "dungvst"
                    )
        }
            )

    @Transactional
    public Result login() {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();

        if (loginForm.hasErrors()) {
            return badRequest(loginForm.errorsAsJson());
        }

        Login login = loginForm.get();

        User user = UserService.findByAccountAndPassword(login.account, login.password);
        if (user == null) {
            return unauthorized();
        }
        else {
            String authToken = user.createToken();
            user.setAuthToken(authToken);
            UserService.update(user);

            ObjectNode authTokenJson = Json.newObject();
            authTokenJson.put(AUTH_TOKEN, authToken);
            //            response().setCookie(Http.Cookie.builder(AUTH_TOKEN, authToken).withSecure(ctx().request().secure()).build());
            response().setCookie(AUTH_TOKEN, authToken);
            return ok(authTokenJson);
        }
    }

    @ApiOperation(
        value = "Logout",
        notes = "")
    @Security.Authenticated(Secured.class)
    public Result logout() {
        response().discardCookie(AUTH_TOKEN);
        getUser().deleteAuthToken();
        return redirect("/");
    }

    public static class Login {

        @Constraints.Required
        public String account;

        @Constraints.Required
        public String password;

    }

}
