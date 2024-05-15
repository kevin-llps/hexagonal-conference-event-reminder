package fr.kevin.llps.conf.event.reminder.domain.service;

import fr.kevin.llps.conf.event.reminder.domain.csv.CsvEvent;
import fr.kevin.llps.conf.event.reminder.domain.ddd.DomainService;
import fr.kevin.llps.conf.event.reminder.domain.ports.client.EventFileParserPort;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static fr.kevin.llps.conf.event.reminder.domain.csv.CsvProperties.DELIMITER;
import static fr.kevin.llps.conf.event.reminder.domain.csv.CsvProperties.HEADERS;

@DomainService
public class EventFileParser implements EventFileParserPort {

    public List<CsvEvent> parse(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        CSVFormat csvFormat = CSVFormat.newFormat(DELIMITER).builder()
                .setHeader(HEADERS)
                .setSkipHeaderRecord(true)
                .build();

        try (CSVParser parser = new CSVParser(inputStreamReader, csvFormat)) {
            return parser.stream()
                    .filter(csvRecord -> csvRecord.size() == HEADERS.length)
                    .map(this::mapToCsvEvent)
                    .toList();
        }
    }

    private CsvEvent mapToCsvEvent(CSVRecord csvRecord) {
        return CsvEvent.builder()
                .title(csvRecord.get(HEADERS[0]))
                .type(csvRecord.get(HEADERS[1]))
                .description(csvRecord.get(HEADERS[2]))
                .date(csvRecord.get(HEADERS[3]))
                .time(csvRecord.get(HEADERS[4]))
                .speaker(csvRecord.get(HEADERS[5]))
                .attendees(csvRecord.get(HEADERS[6]))
                .company(csvRecord.get(HEADERS[7]))
                .build();
    }

}
