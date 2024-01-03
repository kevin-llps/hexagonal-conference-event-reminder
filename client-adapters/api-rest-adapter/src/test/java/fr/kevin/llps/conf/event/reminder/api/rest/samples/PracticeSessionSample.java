package fr.kevin.llps.conf.event.reminder.api.rest.samples;

import fr.kevin.llps.conf.event.reminder.domain.model.Attendee;
import fr.kevin.llps.conf.event.reminder.domain.model.PracticeSession;
import fr.kevin.llps.conf.event.reminder.domain.model.PracticeSessionAttendee;
import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;

import java.time.LocalDateTime;
import java.util.List;

public class PracticeSessionSample {

    public static List<PracticeSession> practiceSessionList() {
        PracticeSession jee = onePracticeSession();

        PracticeSession agile = new PracticeSession(
                "Agile",
                "Présentation et pratique de la méthode agile",
                LocalDateTime.of(2022, 9, 20, 14, 30, 0),
                new Speaker("chris", "arr"));

        Attendee firstAgileAttendee = new Attendee("jean", "dupont");
        Attendee secondAgileAttendee = new Attendee("alex", "dubois");

        PracticeSessionAttendee firstAgilePracticeSessionAttendee = new PracticeSessionAttendee(agile, firstAgileAttendee);
        PracticeSessionAttendee secondAgilePracticeSessionAttendee = new PracticeSessionAttendee(agile, secondAgileAttendee);

        agile.setPracticeSessionAttendees(List.of(firstAgilePracticeSessionAttendee, secondAgilePracticeSessionAttendee));

        return List.of(jee, agile);
    }

    public static PracticeSession onePracticeSession() {
        PracticeSession practiceSession = new PracticeSession(
                "JEE",
                "Session pratique JEE",
                LocalDateTime.of(2023, 4, 11, 19, 0, 0),
                new Speaker("kevin", "llps"));

        Attendee firstJeeAttendee = new Attendee("julien", "arnaud");
        Attendee secondJeeAttendee = new Attendee("mickael", "dupont");

        PracticeSessionAttendee firstJeePracticeSessionAttendee = new PracticeSessionAttendee(practiceSession, firstJeeAttendee);
        PracticeSessionAttendee secondJeePracticeSessionAttendee = new PracticeSessionAttendee(practiceSession, secondJeeAttendee);

        practiceSession.setPracticeSessionAttendees(List.of(firstJeePracticeSessionAttendee, secondJeePracticeSessionAttendee));

        return practiceSession;
    }

}
