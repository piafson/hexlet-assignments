package exercise;

import io.javalin.Javalin;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public final class App {

    public static Javalin getApp() throws JsonProcessingException {

        // BEGIN
        String phones = new ObjectMapper().writeValueAsString(Data.getPhones());
        String domains = new ObjectMapper().writeValueAsString(Data.getDomains());
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        app.get("/domains", ctx -> ctx.result(domains));
        app.get("/phones", ctx -> ctx.result(phones));

        return app;
        // END
    }

    public static void main(String[] args) throws JsonProcessingException {
        Javalin app = getApp();
        app.start(7070);
    }
}
