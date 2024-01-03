package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.mapper;

import fr.kevin.llps.conf.event.reminder.domain.model.PracticeSession;
import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.PracticeSessionEntity;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.SpeakerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PracticeSessionMapper {

    private final SpeakerMapper speakerMapper;

    public List<PracticeSessionEntity> mapToEntities(List<PracticeSession> practiceSessions) {
        return practiceSessions.stream()
                .map(this::mapToEntity)
                .toList();
    }

    private PracticeSessionEntity mapToEntity(PracticeSession practiceSession) {
        SpeakerEntity speakerEntity = speakerMapper.mapToEntity(practiceSession.getSpeaker());

        return new PracticeSessionEntity(practiceSession.getTitle(), practiceSession.getDescription(), practiceSession.getDate(), speakerEntity);
    }

    public List<PracticeSession> mapToDomain(List<PracticeSessionEntity> practiceSessionEntities) {
        return practiceSessionEntities.stream()
                .map(this::mapToDomain)
                .toList();
    }

    private PracticeSession mapToDomain(PracticeSessionEntity practiceSessionEntity) {
        Speaker speaker = speakerMapper.mapToDomain(practiceSessionEntity.getSpeaker());

        return new PracticeSession(practiceSessionEntity.getTitle(), practiceSessionEntity.getDescription(), practiceSessionEntity.getDate(), speaker);
    }

}
