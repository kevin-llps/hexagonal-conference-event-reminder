package fr.kevin.llps.conf.event.reminder.domain.service;

import fr.kevin.llps.conf.event.reminder.domain.csv.CsvEvent;
import fr.kevin.llps.conf.event.reminder.domain.csv.CsvProperties;
import fr.kevin.llps.conf.event.reminder.domain.exception.EventExportException;
import fr.kevin.llps.conf.event.reminder.domain.model.*;
import fr.kevin.llps.conf.event.reminder.domain.ports.client.EventServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.CharUtils.LF;

@Slf4j
@RequiredArgsConstructor
public class EventService implements EventServicePort {

    private final TalkService talkService;
    private final BBLService bblService;
    private final PracticeSessionService practiceSessionService;

    @Override
    public void importEvents(List<CsvEvent> csvEvents) {
        List<CsvEvent> csvTalks = filterByEventType(csvEvents, EventType.TALK);
        List<CsvEvent> csvBBLs = filterByEventType(csvEvents, EventType.BBL);
        List<CsvEvent> csvPracticeSessions = filterByEventType(csvEvents, EventType.PRACTICE_SESSION);

        talkService.importTalks(mapToTalks(csvTalks));
        bblService.importBBLs(mapToBBLs(csvBBLs));
        practiceSessionService.importPracticeSessions(mapToPracticeSessions(csvPracticeSessions));
    }

    private List<CsvEvent> filterByEventType(List<CsvEvent> csvEvents, String eventType) {
        return csvEvents.stream()
                .filter(csvEvent -> csvEvent.type().equals(eventType))
                .toList();
    }

    private List<Talk> mapToTalks(List<CsvEvent> csvTalks) {
        return csvTalks.stream()
                .map(Talk::create)
                .toList();
    }

    private List<BBL> mapToBBLs(List<CsvEvent> csvBBLs) {
        return csvBBLs.stream()
                .map(BBL::create)
                .toList();
    }

    private List<PracticeSession> mapToPracticeSessions(List<CsvEvent> csvPracticeSessions) {
        return csvPracticeSessions.stream()
                .map(PracticeSession::create)
                .toList();
    }

    @Override
    public List<Event> getUpcomingEvents() {
        List<Event> eventDtoList = new ArrayList<>();

        List<Talk> upcomingTalks = talkService.getUpcomingTalks();
        List<BBL> upcomingBBLs = bblService.getUpcomingBBLs();
        List<PracticeSession> upcomingPracticeSessions = practiceSessionService.getUpcomingPracticeSessions();

        eventDtoList.addAll(upcomingTalks);
        eventDtoList.addAll(upcomingBBLs);
        eventDtoList.addAll(upcomingPracticeSessions);

        return eventDtoList;
    }

    @Override
    public byte[] exportEvents() {
        CSVFormat csvFormat = CSVFormat.newFormat(CsvProperties.DELIMITER).builder()
                .setHeader(CsvProperties.HEADERS)
                .setRecordSeparator(LF)
                .build();

        List<Event> events = getAllEvents();

        List<String[]> csvColumns = events.stream()
                .map(Event::getCsvColumns)
                .toList();

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(byteArrayOutputStream), csvFormat)) {

            csvPrinter.printRecords(csvColumns);

            csvPrinter.flush();

            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            log.error("Une erreur est survenue lors de l'export", e);
            throw new EventExportException(e);
        }
    }

    private List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();

        events.addAll(talkService.getAll());
        events.addAll(bblService.getAll());
        events.addAll(practiceSessionService.getAll());

        return events;
    }

}
