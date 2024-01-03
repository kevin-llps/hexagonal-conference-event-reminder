package fr.kevin.llps.conf.event.reminder.api.rest.mapper;

import fr.kevin.llps.conf.event.reminder.api.rest.dto.BBLDto;
import fr.kevin.llps.conf.event.reminder.api.rest.dto.SpeakerDto;
import fr.kevin.llps.conf.event.reminder.domain.model.BBL;
import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static fr.kevin.llps.conf.event.reminder.api.rest.samples.BBLDtoSample.oneBBLDto;
import static fr.kevin.llps.conf.event.reminder.api.rest.samples.BBLSample.oneBBL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BBLDtoMapperTest {

    @Mock
    private SpeakerDtoMapper speakerMapper;

    @InjectMocks
    private BBLDtoMapper bblMapper;

    @Test
    void shouldMapToDto() {
        BBL bbl = oneBBL();
        BBLDto expectedBBLDto = oneBBLDto();

        Speaker speakerChrisArr = new Speaker("chris", "arr");

        SpeakerDto speakerChrisArrDto = SpeakerDto.builder()
                .firstname("chris")
                .lastname("arr")
                .build();

        when(speakerMapper.mapToDto(speakerChrisArr)).thenReturn(speakerChrisArrDto);

        BBLDto bblDto = bblMapper.mapToDto(bbl);

        assertThat(bblDto).isEqualTo(expectedBBLDto);
    }

}
