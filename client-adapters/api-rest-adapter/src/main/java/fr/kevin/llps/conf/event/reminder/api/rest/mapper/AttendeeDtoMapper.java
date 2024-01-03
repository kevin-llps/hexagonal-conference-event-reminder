package fr.kevin.llps.conf.event.reminder.api.rest.mapper;

import fr.kevin.llps.conf.event.reminder.domain.model.Attendee;
import fr.kevin.llps.conf.event.reminder.api.rest.dto.AttendeeDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AttendeeDtoMapper {

    public List<AttendeeDto> mapToDtoList(List<Attendee> attendees) {
        return attendees.stream()
                .map(this::mapToDto)
                .toList();
    }

    private AttendeeDto mapToDto(Attendee attendee) {
        return AttendeeDto.builder()
                .firstname(attendee.firstname())
                .lastname(attendee.lastname())
                .build();
    }

}
