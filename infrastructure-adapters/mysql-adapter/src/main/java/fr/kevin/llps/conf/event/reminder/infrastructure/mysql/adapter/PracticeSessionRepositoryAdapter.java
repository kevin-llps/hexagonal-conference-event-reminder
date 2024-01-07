package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.adapter;

import fr.kevin.llps.conf.event.reminder.domain.model.PracticeSession;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.PracticeSessionRepositoryPort;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.PracticeSessionEntity;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.mapper.PracticeSessionMapper;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.repository.PracticeSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PracticeSessionRepositoryAdapter implements PracticeSessionRepositoryPort {

    private final PracticeSessionRepository practiceSessionRepository;

    private final PracticeSessionMapper practiceSessionMapper;

    @Override
    public void saveAll(List<PracticeSession> practiceSessions) {
        List<PracticeSessionEntity> practiceSessionEntities = practiceSessionMapper.mapToEntities(practiceSessions);

        practiceSessionRepository.saveAll(practiceSessionEntities);
    }

    @Override
    public List<PracticeSession> findByDateLaterThan(LocalDateTime date) {
        List<PracticeSessionEntity> practiceSessionEntities = practiceSessionRepository.findByDateLaterThan(date);

        return practiceSessionMapper.mapToDomain(practiceSessionEntities);
    }

    @Override
    public List<PracticeSession> findAllOrderedByDate() {
        List<PracticeSessionEntity> practiceSessionEntities = practiceSessionRepository.findAllOrderedByDate();

        return practiceSessionMapper.mapToDomain(practiceSessionEntities);
    }


}
