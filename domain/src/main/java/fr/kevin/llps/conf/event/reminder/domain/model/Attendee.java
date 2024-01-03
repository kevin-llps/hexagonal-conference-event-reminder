package fr.kevin.llps.conf.event.reminder.domain.model;

import java.util.UUID;

public record Attendee(UUID id,
                       String firstname,
                       String lastname) {

    public Attendee(String firstname, String lastname) {
        this(null, firstname, lastname);
    }

    public static Attendee create(String attendee) {
        String[] attendeeParts = attendee.split(" ", 2);

        return new Attendee(attendeeParts[0], attendeeParts[1]);
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstname, lastname);
    }

}
