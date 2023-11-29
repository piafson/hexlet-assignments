package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import java.util.Collections;
import exercise.repository.UserRepository;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void register(Context ctx) throws Exception {
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = Security.encrypt(ctx.formParam("password"));

        var token = Security.generateToken();
        ctx.cookie("token", token);

        User newUser = new User(firstName, lastName, email, password, token);
        UserRepository.save(newUser);
        User createdUser = UserRepository.getEntities().stream()
                .filter(user -> user.getToken().equals(token))
                .findAny()
                .orElse(null);
        var id = createdUser.getId();
        ctx.redirect(NamedRoutes.userPath(id));
    }

    public static void show(Context ctx) throws Exception {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var token = ctx.cookie("token");

        User user = UserRepository.find(id)
                .filter(u -> u.getToken().equals(token))
                .orElse(null);
        if (user != null) {
            ctx.render("users/show.jte", Collections.singletonMap("user", user));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }

    }
    // END
}
