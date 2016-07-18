package controllers;


import models.Md0002User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;
import services.Md0002UserService;


public class Secured extends Security.Authenticator {
    final static Logger logger = LoggerFactory.getLogger(Secured.class);

    @Override
    public String getUsername(Context ctx) {
        String[] authTokenHeaderValues = ctx.request().headers().get(SecurityController.AUTH_TOKEN_HEADER);
        if ((authTokenHeaderValues != null) && (authTokenHeaderValues.length == 1) && (authTokenHeaderValues[0] != null)) {
            Md0002UserService userSv = new Md0002UserService();
            Md0002User user = new Md0002User();

            try {
                user = userSv.findByAuthToken(authTokenHeaderValues[0]);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            if (user != null) {
                ctx.args.put("user", user);
                return user.getFullname();
            }
        }

        return null;
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return unauthorized();
    }

}