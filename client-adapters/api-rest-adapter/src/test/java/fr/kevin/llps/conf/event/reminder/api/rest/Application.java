package fr.kevin.llps.conf.event.reminder.api.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "fr.kevin.llps.conf.event.reminder")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
