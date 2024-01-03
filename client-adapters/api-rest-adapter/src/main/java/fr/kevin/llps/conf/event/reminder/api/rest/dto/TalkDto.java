package fr.kevin.llps.conf.event.reminder.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TalkDto(@JsonProperty("title") String title,
                      @JsonProperty("description") String description,
                      @JsonProperty("date") LocalDateTime date,
                      @JsonProperty("speaker") SpeakerDto speaker) implements EventDto {
}
