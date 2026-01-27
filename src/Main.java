import io.javalin.Javalin;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DBHandler dbHandler = new DBHandler();

        Javalin app = Javalin.create().start(7000);

        System.out.println("Social Network API is running on http://localhost:7000");


        app.get("/profiles", ctx -> {
            List<Profile> profiles = dbHandler.getAllProfiles();
            ctx.json(profiles); // Автоматически превращает List<Profile> в JSON
        });

        app.post("/profiles", ctx -> {
            Profile newProfile = ctx.bodyAsClass(Profile.class);

            dbHandler.addProfile(newProfile);

            ctx.status(201); // Код 201 означает "Created" (Успешно создано)
            ctx.result("Profile created");
        });

        app.put("/profiles/{username}", ctx -> {
            String username = ctx.pathParam("username"); // Берем имя из ссылки

            Profile body = ctx.bodyAsClass(Profile.class);

            dbHandler.updateFollowers(username, body.getFollowersCount());

            ctx.result("Followers updated for " + username);
        });

        app.delete("/profiles/{username}", ctx -> {
            String username = ctx.pathParam("username"); // Берем имя из ссылки

            dbHandler.deleteProfile(username);

            ctx.result("Profile " + username + " deleted");
        });
    }
}