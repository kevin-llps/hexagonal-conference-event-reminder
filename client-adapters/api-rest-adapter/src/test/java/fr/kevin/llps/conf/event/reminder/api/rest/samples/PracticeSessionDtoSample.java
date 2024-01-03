package fr.kevin.llps.conf.event.reminder.api.rest.samples;

import fr.kevin.llps.conf.event.reminder.api.rest.dto.AttendeeDto;
import fr.kevin.llps.conf.event.reminder.api.rest.dto.PracticeSessionDto;
import fr.kevin.llps.conf.event.reminder.api.rest.dto.SpeakerDto;

import java.time.LocalDateTime;
import java.util.List;

public class PracticeSessionDtoSample {

    public static PracticeSessionDto onePracticeSessionDto() {
        SpeakerDto speakerDto = SpeakerDto.builder()
                .firstname("kevin")
                .lastname("llps")
                .build();

        AttendeeDto firstAttendeeDto = AttendeeDto.builder()
                .firstname("julien")
                .lastname("arnaud")
                .build();

        AttendeeDto secondAttendeeDto = AttendeeDto.builder()
                .firstname("mickael")
                .lastname("dupont")
                .build();

        return PracticeSessionDto.builder()
                .title("JEE")
                .description("Session pratique JEE")
                .date(LocalDateTime.of(2023, 4, 11, 19, 0, 0))
                .speaker(speakerDto)
                .attendees(List.of(firstAttendeeDto, secondAttendeeDto))
                .build();
    }

}
