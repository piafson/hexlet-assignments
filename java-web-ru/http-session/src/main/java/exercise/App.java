package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() throws JsonProcessingException {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            List <Map<String, String>> res = new ArrayList<>();
            if (ctx.queryParam("page") == null) {
               for (int i = 0; i < per; i++) {
                    res.add(USERS.get(i));
                }
                ctx.result(new ObjectMapper().writeValueAsString(res));
            } else {
                int min = page * per - per;
                int max = page * per;
                for (int i = min; i < max; i++) {
                    res.add(USERS.get(i));
                }
                ctx.result(new ObjectMapper().writeValueAsString(res));
            }
        });
        // END

        return app;

    }

    public static void main(String[] args) throws JsonProcessingException {
        Javalin app = getApp();
        app.start(7070);
    }
}
