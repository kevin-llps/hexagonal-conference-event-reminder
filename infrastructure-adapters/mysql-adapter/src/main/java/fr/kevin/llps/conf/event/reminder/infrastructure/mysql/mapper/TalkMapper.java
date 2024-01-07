package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.mapper;

import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;
import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.TalkEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TalkMapper {

    private final SpeakerMapper speakerMapper;

    public List<Talk> mapToDomain(List<TalkEntity> talkEntities) {
        return talkEntities.stream()
                .map(this::mapToDomain)
                .toList();
    }

    private Talk mapToDomain(TalkEntity talkEntity) {
        Speaker speaker = speakerMapper.mapToDomain(talkEntity.getSpeaker());

        return new Talk(talkEntity.getTitle(), talkEntity.getDescription(), talkEntity.getDate(), speaker);
    }

}
