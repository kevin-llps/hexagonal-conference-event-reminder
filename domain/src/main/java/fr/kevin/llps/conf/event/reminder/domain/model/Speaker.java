package fr.kevin.llps.conf.event.reminder.domain.model;

import java.util.UUID;

public record Speaker(UUID id,
                      String firstname,
                      String lastname) {

    public Speaker(String firstname, String lastname) {
        this(null, firstname, lastname);
    }

    public static Speaker create(String speaker) {
        String[] speakerParts = speaker.split(" ", 2);

        return new Speaker(speakerParts[0], speakerParts[1]);
    }

}
