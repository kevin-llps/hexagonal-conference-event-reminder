package fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure;

import fr.kevin.llps.conf.event.reminder.domain.model.Attendee;

import java.util.List;

public interface AttendeeRepositoryPort {

    void saveAll(List<Attendee> attendees);

}
