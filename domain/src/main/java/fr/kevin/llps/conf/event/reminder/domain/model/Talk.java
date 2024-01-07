package fr.kevin.llps.conf.event.reminder.domain.model;

import fr.kevin.llps.conf.event.reminder.domain.DateUtils;
import fr.kevin.llps.conf.event.reminder.domain.csv.CsvEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public record Talk(UUID id,
                   String title,
                   String description,
                   LocalDateTime date,
                   Speaker speaker) implements Event {

    public Talk(String title, String description, LocalDateTime date, Speaker speaker) {
        this(null, title, description, date, speaker);
    }

    public static Talk create(CsvEvent csvEvent) {
        return new Talk(
                csvEvent.title(),
                csvEvent.description(),
                DateUtils.mapToLocalDateTime(csvEvent.date(), csvEvent.time()),
                Speaker.create(csvEvent.speaker()));
    }

    @Override
    public String[] getCsvColumns() {
        return new String[]{
                title,
                getEventType(),
                description,
                date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                date.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                String.format("%s %s", speaker.firstname(), speaker.lastname()),
                "", ""};
    }

    @Override
    public String getEventType() {
        return EventType.TALK;
    }

}
