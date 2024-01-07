package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.mapper;

import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.SpeakerEntity;
import org.springframework.stereotype.Component;

@Component
public class SpeakerMapper {

    public Speaker mapToDomain(SpeakerEntity speakerEntity) {
        return new Speaker(speakerEntity.getFirstname(), speakerEntity.getLastname());
    }
}
