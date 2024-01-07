package fr.kevin.llps.conf.event.reminder.domain;

import lombok.RequiredArgsConstructor;

import java.time.Clock;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.SECONDS;

@RequiredArgsConstructor
public class DateUtils {

    private final Clock clock;

    public static LocalDateTime mapToLocalDateTime(String date, String time) {
        return LocalDateTime.parse(mapToLocalDateTimeString(date, time));
    }

    private static String mapToLocalDateTimeString(String date, String time) {
        String[] dateParts = date.split("/");

        String localDate = String.join("-", dateParts[2], dateParts[1], dateParts[0]);

        return localDate + "T" + time;
    }

    public LocalDateTime getCurrentDate() {
        return LocalDateTime.now(clock).truncatedTo(SECONDS);
    }

}
