package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.mapper;

import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.SpeakerEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpeakerMapper {

    public List<SpeakerEntity> mapToEntities(List<Speaker> speakers) {
        return speakers.stream()
                .map(this::mapToEntity)
                .toList();
    }

    public SpeakerEntity mapToEntity(Speaker speaker) {
        return new SpeakerEntity(speaker.firstname(), speaker.lastname());
    }

    public Speaker mapToDomain(SpeakerEntity speakerEntity) {
        return new Speaker(speakerEntity.getFirstname(), speakerEntity.getLastname());
    }
}
