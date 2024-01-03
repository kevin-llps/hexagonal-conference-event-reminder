package fr.kevin.llps.conf.event.reminder.api.rest.mapper;

import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;
import fr.kevin.llps.conf.event.reminder.api.rest.dto.SpeakerDto;
import org.springframework.stereotype.Component;

@Component
public class SpeakerDtoMapper {

    public SpeakerDto mapToDto(Speaker speaker) {
        return SpeakerDto.builder()
                .firstname(speaker.firstname())
                .lastname(speaker.lastname())
                .build();
    }

}
