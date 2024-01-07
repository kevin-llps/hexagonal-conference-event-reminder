package fr.kevin.llps.conf.event.reminder.domain.model;

import fr.kevin.llps.conf.event.reminder.domain.DateUtils;
import fr.kevin.llps.conf.event.reminder.domain.csv.CsvEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public record BBL(UUID id,
                  String title,
                  String description,
                  LocalDateTime date,
                  Speaker speaker,
                  String company) implements Event {

    public BBL(String title, String description, LocalDateTime date, Speaker speaker, String company) {
        this(null, title, description, date, speaker, company);
    }

    public static BBL create(CsvEvent csvEvent) {
        return new BBL(
                csvEvent.title(),
                csvEvent.description(),
                DateUtils.mapToLocalDateTime(csvEvent.date(), csvEvent.time()),
                Speaker.create(csvEvent.speaker()),
                csvEvent.company());
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
                "",
                company};
    }

    @Override
    public String getEventType() {
        return EventType.BBL;
    }

}
