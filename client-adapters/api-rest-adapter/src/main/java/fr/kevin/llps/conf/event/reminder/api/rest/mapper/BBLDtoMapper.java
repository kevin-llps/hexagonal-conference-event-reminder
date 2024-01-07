package fr.kevin.llps.conf.event.reminder.api.rest.mapper;

import fr.kevin.llps.conf.event.reminder.api.rest.dto.BBLDto;
import fr.kevin.llps.conf.event.reminder.api.rest.dto.SpeakerDto;
import fr.kevin.llps.conf.event.reminder.domain.model.BBL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BBLDtoMapper {

    private final SpeakerDtoMapper speakerMapper;

    public BBLDto mapToDto(BBL bbl) {
        SpeakerDto speakerDto = speakerMapper.mapToDto(bbl.speaker());

        return BBLDto.builder()
                .title(bbl.title())
                .description(bbl.description())
                .date(bbl.date())
                .speaker(speakerDto)
                .company(bbl.company())
                .build();
    }

}
