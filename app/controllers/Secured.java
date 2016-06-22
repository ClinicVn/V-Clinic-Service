package controllers;


import models.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;
import services.UserService;


public class Secured extends Security.Authenticator {
    final static Logger logger = LoggerFactory.getLogger(Secured.class);

    @Override
    public String getUsername(Context ctx) {
        String[] authTokenHeaderValues = ctx.request().headers().get(SecurityController.AUTH_TOKEN_HEADER);
        if ((authTokenHeaderValues != null) && (authTokenHeaderValues.length == 1) && (authTokenHeaderValues[0] != null)) {
            UserService userSv = new UserService();
            User user = new User();

            try {
                user = userSv.findByAuthToken2(authTokenHeaderValues[0]);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            if (user != null) {
                ctx.args.put("user", user);
                return user.getName();
            }
        }

        return null;
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return unauthorized();
    }

}