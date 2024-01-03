package fr.kevin.llps.conf.event.reminder.api.rest.samples;

import fr.kevin.llps.conf.event.reminder.domain.model.Attendee;
import fr.kevin.llps.conf.event.reminder.domain.model.PracticeSession;
import fr.kevin.llps.conf.event.reminder.domain.model.PracticeSessionAttendee;

public class PracticeSessionAttendeeSample {

    public static PracticeSessionAttendee onePracticeSessionAttendee(PracticeSession practiceSession, Attendee attendee) {
        return new PracticeSessionAttendee(practiceSession, attendee);
    }

}
