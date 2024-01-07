package fr.kevin.llps.conf.event.reminder;

import fr.kevin.llps.conf.event.reminder.bootstrap.config.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({AppConfiguration.class})
@SpringBootApplication(scanBasePackages = "fr.kevin.llps.conf.event.reminder")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
