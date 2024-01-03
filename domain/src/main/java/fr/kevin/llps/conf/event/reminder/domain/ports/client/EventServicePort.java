package fr.kevin.llps.conf.event.reminder.domain.ports.client;

import fr.kevin.llps.conf.event.reminder.domain.csv.CsvEvent;
import fr.kevin.llps.conf.event.reminder.domain.model.Event;

import java.util.List;

public interface EventServicePort {

    void importEvents(List<CsvEvent> csvEvents);

    List<Event> getUpcomingEvents();

    byte[] exportEvents();

}
