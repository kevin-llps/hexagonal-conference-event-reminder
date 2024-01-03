package fr.kevin.llps.conf.event.reminder.api.rest.mapper;

import fr.kevin.llps.conf.event.reminder.api.rest.dto.AttendeeDto;
import fr.kevin.llps.conf.event.reminder.api.rest.dto.PracticeSessionDto;
import fr.kevin.llps.conf.event.reminder.api.rest.dto.SpeakerDto;
import fr.kevin.llps.conf.event.reminder.domain.model.Attendee;
import fr.kevin.llps.conf.event.reminder.domain.model.PracticeSession;
import fr.kevin.llps.conf.event.reminder.domain.model.PracticeSessionAttendee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PracticeSessionDtoMapper {

    private final SpeakerDtoMapper speakerMapper;
    private final AttendeeDtoMapper attendeeMapper;

    public PracticeSessionDto mapToDto(PracticeSession practiceSession) {
        SpeakerDto speakerDto = speakerMapper.mapToDto(practiceSession.getSpeaker());
        List<AttendeeDto> attendeeDtoList = attendeeMapper.mapToDtoList(getAttendees(practiceSession));

        return PracticeSessionDto.builder()
                .title(practiceSession.getTitle())
                .description(practiceSession.getDescription())
                .date(practiceSession.getDate())
                .speaker(speakerDto)
                .attendees(attendeeDtoList)
                .build();
    }

    private List<Attendee> getAttendees(PracticeSession practiceSession) {
        return practiceSession.getPracticeSessionAttendees().stream()
                .map(PracticeSessionAttendee::attendee)
                .toList();
    }

}
