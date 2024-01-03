package fr.kevin.llps.conf.event.reminder.domain.service;

import fr.kevin.llps.conf.event.reminder.domain.model.Attendee;
import fr.kevin.llps.conf.event.reminder.domain.model.PracticeSession;
import fr.kevin.llps.conf.event.reminder.domain.model.PracticeSessionAttendee;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.PracticeSessionRepositoryPort;
import fr.kevin.llps.conf.event.reminder.domain.utils.DateUtils;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.AttendeeRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class PracticeSessionService {

    private final PracticeSessionRepositoryPort practiceSessionRepositoryPort;
    private final AttendeeRepositoryPort attendeeRepositoryPort;
    private final DateUtils dateUtils;

    public void importPracticeSessions(List<PracticeSession> practiceSessions) {
        attendeeRepositoryPort.saveAll(getAttendees(practiceSessions));
        practiceSessionRepositoryPort.saveAll(practiceSessions);
    }

    private static List<Attendee> getAttendees(List<PracticeSession> practiceSessions) {
        return practiceSessions.stream()
                .map(PracticeSession::getPracticeSessionAttendees)
                .flatMap(Collection::stream)
                .map(PracticeSessionAttendee::attendee)
                .toList();
    }

    public List<PracticeSession> getUpcomingPracticeSessions() {
        LocalDateTime currentDate = dateUtils.getCurrentDate();

        return practiceSessionRepositoryPort.findByDateLaterThan(currentDate);
    }

    public List<PracticeSession> getAll() {
        return practiceSessionRepositoryPort.findAllOrderedByDate();
    }
}
