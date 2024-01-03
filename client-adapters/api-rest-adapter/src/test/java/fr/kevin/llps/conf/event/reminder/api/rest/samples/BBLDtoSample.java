package fr.kevin.llps.conf.event.reminder.api.rest.samples;

import fr.kevin.llps.conf.event.reminder.api.rest.dto.BBLDto;
import fr.kevin.llps.conf.event.reminder.api.rest.dto.SpeakerDto;

import java.time.LocalDateTime;

public class BBLDtoSample {

    public static BBLDto oneBBLDto() {
        SpeakerDto speakerDto = SpeakerDto.builder()
                .firstname("chris")
                .lastname("arr")
                .build();

        return BBLDto.builder()
                .title("Git")
                .description("Présentation du fonctionnement de Git")
                .date(LocalDateTime.of(2022, 9, 6, 12, 0, 0))
                .speaker(speakerDto)
                .company("MadMax Corp")
                .build();
    }

}
