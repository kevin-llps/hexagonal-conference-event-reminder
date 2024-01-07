package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.mapper;

import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.SpeakerEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpeakerMapperTest {

    @Test
    void shouldMapToDomain() {
        SpeakerMapper speakerMapper = new SpeakerMapper();

        SpeakerEntity speakerEntity = new SpeakerEntity("kevin", "llps");

        Speaker speaker = speakerMapper.mapToDomain(speakerEntity);

        assertThat(speaker.firstname()).isEqualTo(speakerEntity.getFirstname());
        assertThat(speaker.lastname()).isEqualTo(speakerEntity.getLastname());
    }

}
