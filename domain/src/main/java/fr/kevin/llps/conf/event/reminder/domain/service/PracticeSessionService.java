package fr.kevin.llps.conf.event.reminder.domain.service;

import fr.kevin.llps.conf.event.reminder.domain.DateUtils;
import fr.kevin.llps.conf.event.reminder.domain.ddd.DomainService;
import fr.kevin.llps.conf.event.reminder.domain.model.Attendee;
import fr.kevin.llps.conf.event.reminder.domain.model.PracticeSession;
import fr.kevin.llps.conf.event.reminder.domain.model.PracticeSessionAttendee;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.AttendeeRepositoryPort;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.PracticeSessionRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@DomainService
@RequiredArgsConstructor
public class PracticeSessionService {

    private final PracticeSessionRepositoryPort practiceSessionRepositoryPort;
    private final AttendeeRepositoryPort attendeeRepositoryPort;
    private final DateUtils dateUtils;

    private static List<Attendee> getAttendees(List<PracticeSession> practiceSessions) {
        return practiceSessions.stream()
                .map(PracticeSession::getPracticeSessionAttendees)
                .flatMap(Collection::stream)
                .map(PracticeSessionAttendee::attendee)
                .toList();
    }

    public void importPracticeSessions(List<PracticeSession> practiceSessions) {
        attendeeRepositoryPort.saveAll(getAttendees(practiceSessions));
        practiceSessionRepositoryPort.saveAll(practiceSessions);
    }

    public List<PracticeSession> getUpcomingPracticeSessions() {
        LocalDateTime currentDate = dateUtils.getCurrentDate();

        return practiceSessionRepositoryPort.findByDateLaterThan(currentDate);
    }

    public List<PracticeSession> getAll() {
        return practiceSessionRepositoryPort.findAllOrderedByDate();
    }
}
