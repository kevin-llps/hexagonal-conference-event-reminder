package fr.kevin.llps.conf.event.reminder.api.rest.mapper;

import fr.kevin.llps.conf.event.reminder.api.rest.dto.SpeakerDto;
import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpeakerDtoMapperTest {

    @Test
    void shouldMapToDto() {
        Speaker speaker = new Speaker("kevin", "llps");

        SpeakerDtoMapper speakerMapper = new SpeakerDtoMapper();

        SpeakerDto speakerDto = speakerMapper.mapToDto(speaker);

        assertThat(speakerDto.firstname()).isEqualTo(speaker.firstname());
        assertThat(speakerDto.lastname()).isEqualTo(speaker.lastname());
    }

}
