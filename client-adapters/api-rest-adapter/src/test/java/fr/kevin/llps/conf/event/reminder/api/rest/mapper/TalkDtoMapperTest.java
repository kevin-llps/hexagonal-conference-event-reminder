package fr.kevin.llps.conf.event.reminder.api.rest.mapper;

import fr.kevin.llps.conf.event.reminder.api.rest.dto.SpeakerDto;
import fr.kevin.llps.conf.event.reminder.api.rest.dto.TalkDto;
import fr.kevin.llps.conf.event.reminder.api.rest.samples.TalkDtoSample;
import fr.kevin.llps.conf.event.reminder.api.rest.samples.TalkSample;
import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;
import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TalkDtoMapperTest {

    @Mock
    private SpeakerDtoMapper speakerMapper;

    @InjectMocks
    private TalkDtoMapper talkMapper;

    @Test
    void shouldMapToDtoList() {
        Talk talk = TalkSample.oneTalk();
        TalkDto expectedTalkDto = TalkDtoSample.oneTalkDto();

        Speaker speakerKevLps = new Speaker("kevin", "llps");

        SpeakerDto speakerKevLpsDto = SpeakerDto.builder()
                .firstname("kevin")
                .lastname("llps")
                .build();

        when(speakerMapper.mapToDto(speakerKevLps)).thenReturn(speakerKevLpsDto);

        TalkDto talkDto = talkMapper.mapToDto(talk);

        assertThat(talkDto).isEqualTo(expectedTalkDto);
    }

}
