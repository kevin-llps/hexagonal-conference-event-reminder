package fr.kevin.llps.conf.event.reminder.domain.ports.client;

import fr.kevin.llps.conf.event.reminder.domain.csv.CsvEvent;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface EventFileParserPort {

    List<CsvEvent> parse(InputStream inputStream) throws IOException;

}
