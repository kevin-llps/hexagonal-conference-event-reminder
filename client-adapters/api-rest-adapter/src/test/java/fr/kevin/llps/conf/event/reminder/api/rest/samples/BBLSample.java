package fr.kevin.llps.conf.event.reminder.api.rest.samples;

import fr.kevin.llps.conf.event.reminder.domain.model.BBL;
import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;

import java.time.LocalDateTime;
import java.util.List;

public class BBLSample {

    public static List<BBL> bblList() {
        BBL git = oneBBL();

        BBL spring = new BBL(
                "Spring",
                "Présentation de Spring",
                LocalDateTime.of(2023, 3, 24, 12, 30, 0),
                new Speaker("kevin", "llps"),
                "Rockstar Corp");

        return List.of(spring, git);
    }

    public static BBL oneBBL() {
        return new BBL(
                "Git",
                "Présentation du fonctionnement de Git",
                LocalDateTime.of(2022, 9, 6, 12, 0, 0),
                new Speaker("chris", "arr"),
                "MadMax Corp");
    }

}
