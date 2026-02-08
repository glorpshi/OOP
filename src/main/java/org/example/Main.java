package org.example;

import org.example.controller.SocialController;
import org.example.repository.PostgresRepository;
import org.example.repository.SocialRepository;

public class Main {
    public static void main(String[] args) {

        // creating repository
        SocialRepository repository = new PostgresRepository();

        // creating controller and connecting with repository
        SocialController controller = new SocialController(repository);

        // server start
        controller.start();
    }
}