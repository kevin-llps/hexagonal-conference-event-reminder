package fr.kevin.llps.conf.event.reminder.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record SpeakerDto(@JsonProperty("firstname") String firstname,
                         @JsonProperty("lastname") String lastname) {
}
