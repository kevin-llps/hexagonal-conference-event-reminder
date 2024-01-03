package fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure;

import fr.kevin.llps.conf.event.reminder.domain.model.PracticeSession;

import java.time.LocalDateTime;
import java.util.List;

public interface PracticeSessionRepositoryPort {

    void saveAll(List<PracticeSession> practiceSessions);

    List<PracticeSession> findByDateLaterThan(LocalDateTime date);

    List<PracticeSession> findAllOrderedByDate();

}
