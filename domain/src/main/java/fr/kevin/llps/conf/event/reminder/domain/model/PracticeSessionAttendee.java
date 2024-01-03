package fr.kevin.llps.conf.event.reminder.domain.model;

import java.util.UUID;

public record PracticeSessionAttendee(UUID id,
                                      PracticeSession practiceSession,
                                      Attendee attendee) {

    public PracticeSessionAttendee(PracticeSession practiceSession, Attendee attendee) {
        this(null, practiceSession, attendee);
    }

}
