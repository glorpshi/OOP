package org.example.controller;

import io.javalin.Javalin;
import org.example.domain.Post;
import org.example.domain.Profile;
import org.example.repository.SocialRepository;

public class SocialController {
    private final SocialRepository repo;

    public SocialController(SocialRepository repo) {
        this.repo = repo;
    }

    public void start() {
        Javalin app = Javalin.create().start(7000);
        System.out.println("API running on http://localhost:7000");

        app.get("/profiles", ctx -> ctx.json(repo.getAllProfiles()));

        app.post("/profiles", ctx -> {
            Profile p = ctx.bodyAsClass(Profile.class);
            repo.addProfile(p);
            ctx.status(201).result("Profile created");
        });

        app.put("/profiles/{username}", ctx -> {
            String username = ctx.pathParam("username");
            Profile body = ctx.bodyAsClass(Profile.class);
            repo.updateFollowers(username, body.getFollowersCount());
            ctx.result("Updated");
        });

        app.delete("/profiles/{username}", ctx -> {
            repo.deleteProfile(ctx.pathParam("username"));
            ctx.result("Deleted");
        });

        app.post("/posts", ctx -> {
            Post p = ctx.bodyAsClass(Post.class);
            repo.addPost(p);
            ctx.status(201).result("Post created");
        });

        app.get("/posts/{author}", ctx -> {
            String author = ctx.pathParam("author");
            ctx.json(repo.getPostsByAuthor(author));
        });
    }
}