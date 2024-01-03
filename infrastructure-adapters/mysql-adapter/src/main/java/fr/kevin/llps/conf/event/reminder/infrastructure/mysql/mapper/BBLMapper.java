package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.mapper;

import fr.kevin.llps.conf.event.reminder.domain.model.BBL;
import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.BBLEntity;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.SpeakerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BBLMapper {

    private final SpeakerMapper speakerMapper;

    public List<BBLEntity> mapToEntities(List<BBL> bblList) {
        return bblList.stream()
                .map(this::mapToEntity)
                .toList();
    }

    private BBLEntity mapToEntity(BBL bbl) {
        SpeakerEntity speakerEntity = speakerMapper.mapToEntity(bbl.speaker());

        return new BBLEntity(bbl.title(), bbl.description(), bbl.date(), speakerEntity, bbl.company());
    }

    public List<BBL> mapToDomain(List<BBLEntity> bblEntities) {
        return bblEntities.stream()
                .map(this::mapToDomain)
                .toList();
    }

    private BBL mapToDomain(BBLEntity bblEntity) {
        Speaker speaker = speakerMapper.mapToDomain(bblEntity.getSpeaker());

        return new BBL(bblEntity.getTitle(), bblEntity.getDescription(), bblEntity.getDate(), speaker, bblEntity.getCompany());
    }

}
