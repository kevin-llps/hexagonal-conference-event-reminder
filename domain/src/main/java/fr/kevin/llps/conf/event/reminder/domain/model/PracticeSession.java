package fr.kevin.llps.conf.event.reminder.domain.model;

import fr.kevin.llps.conf.event.reminder.domain.DateUtils;
import fr.kevin.llps.conf.event.reminder.domain.csv.CsvEvent;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class PracticeSession implements Event {

    private final String title;
    private final String description;
    private final LocalDateTime date;
    private final Speaker speaker;
    private UUID id;
    private List<PracticeSessionAttendee> practiceSessionAttendees = new ArrayList<>();

    public PracticeSession(String title, String description, LocalDateTime date, Speaker speaker) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.speaker = speaker;
    }

    public static PracticeSession create(CsvEvent csvEvent) {
        PracticeSession practiceSession = new PracticeSession(
                csvEvent.title(),
                csvEvent.description(),
                DateUtils.mapToLocalDateTime(csvEvent.date(), csvEvent.time()),
                Speaker.create(csvEvent.speaker()));

        List<PracticeSessionAttendee> practiceSessionAttendees = mapToPracticeSessionAttendees(csvEvent, practiceSession);

        practiceSession.setPracticeSessionAttendees(practiceSessionAttendees);

        return practiceSession;
    }

    private static List<PracticeSessionAttendee> mapToPracticeSessionAttendees(CsvEvent csvEvent, PracticeSession practiceSession) {
        return Arrays.stream(csvEvent.attendees().split(","))
                .map(Attendee::create)
                .map(attendee -> new PracticeSessionAttendee(practiceSession, attendee))
                .toList();
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
                getCsvAttendees(),
                ""};
    }

    private String getCsvAttendees() {
        return practiceSessionAttendees.stream()
                .map(PracticeSessionAttendee::attendee)
                .map(Attendee::toString)
                .sorted()
                .collect(Collectors.joining(","));
    }

    @Override
    public String getEventType() {
        return EventType.PRACTICE_SESSION;
    }

    public void setPracticeSessionAttendees(List<PracticeSessionAttendee> practiceSessionAttendees) {
        this.practiceSessionAttendees = practiceSessionAttendees;
    }
}
