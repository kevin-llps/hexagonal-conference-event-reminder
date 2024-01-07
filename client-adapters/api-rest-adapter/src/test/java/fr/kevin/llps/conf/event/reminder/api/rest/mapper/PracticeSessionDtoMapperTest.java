package fr.kevin.llps.conf.event.reminder.api.rest.mapper;

import fr.kevin.llps.conf.event.reminder.api.rest.dto.AttendeeDto;
import fr.kevin.llps.conf.event.reminder.api.rest.dto.PracticeSessionDto;
import fr.kevin.llps.conf.event.reminder.api.rest.dto.SpeakerDto;
import fr.kevin.llps.conf.event.reminder.api.rest.samples.PracticeSessionDtoSample;
import fr.kevin.llps.conf.event.reminder.api.rest.samples.PracticeSessionSample;
import fr.kevin.llps.conf.event.reminder.domain.model.Attendee;
import fr.kevin.llps.conf.event.reminder.domain.model.PracticeSession;
import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PracticeSessionDtoMapperTest {

    @Mock
    private AttendeeDtoMapper attendeeMapper;

    @Mock
    private SpeakerDtoMapper speakerMapper;

    @InjectMocks
    private PracticeSessionDtoMapper practiceSessionMapper;

    @Test
    void shouldMapToDto() {
        PracticeSession practiceSession = PracticeSessionSample.onePracticeSession();
        PracticeSessionDto expectedPracticeSessionDto = PracticeSessionDtoSample.onePracticeSessionDto();

        Speaker speakerKevLps = new Speaker("kevin", "llps");

        SpeakerDto speakerKevLpsDto = SpeakerDto.builder()
                .firstname("kevin")
                .lastname("llps")
                .build();

        Attendee firstJeeAttendee = new Attendee("julien", "arnaud");
        Attendee secondJeeAttendee = new Attendee("mickael", "dupont");

        AttendeeDto firstJeeAttendeeDto = AttendeeDto.builder()
                .firstname("julien")
                .lastname("arnaud")
                .build();

        AttendeeDto secondJeeAttendeeDto = AttendeeDto.builder()
                .firstname("mickael")
                .lastname("dupont")
                .build();

        when(speakerMapper.mapToDto(speakerKevLps)).thenReturn(speakerKevLpsDto);

        List<AttendeeDto> expectedJeeAttendees = List.of(firstJeeAttendeeDto, secondJeeAttendeeDto);

        when(attendeeMapper.mapToDtoList(List.of(firstJeeAttendee, secondJeeAttendee)))
                .thenReturn(expectedJeeAttendees);

        PracticeSessionDto practiceSessionDto = practiceSessionMapper.mapToDto(practiceSession);

        assertThat(practiceSessionDto).isEqualTo(expectedPracticeSessionDto);
    }

}
