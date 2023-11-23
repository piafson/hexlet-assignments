package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.NotFoundResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("companies/{id}", ctx -> {
           var compId = ctx.pathParamAsClass("id", Integer.class).get();
           if (compId >= COMPANIES.size() + 1 || compId < 0) {
               throw new NotFoundResponse("Company not found");
           }

           COMPANIES.forEach(s -> {
               if (Integer.parseInt(s.get("id")) == compId) {
                   try {
                       ctx.result(new ObjectMapper().writeValueAsString(s));
                   } catch (JsonProcessingException e) {
                       throw new RuntimeException(e);
                   }
               }
            });

        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
