package fr.kevin.llps.conf.event.reminder.api.rest;

import fr.kevin.llps.conf.event.reminder.api.rest.dto.EventDto;
import fr.kevin.llps.conf.event.reminder.api.rest.mapper.EventDtoMapper;
import fr.kevin.llps.conf.event.reminder.domain.csv.CsvEvent;
import fr.kevin.llps.conf.event.reminder.domain.ports.client.EventFileParserPort;
import fr.kevin.llps.conf.event.reminder.domain.ports.client.EventServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventFileParserPort eventFileParserPort;
    private final EventServicePort eventServicePort;
    private final EventDtoMapper eventMapper;

    @PostMapping("/import")
    @ResponseStatus(NO_CONTENT)
    public void importEvents(@RequestParam("file") MultipartFile fileToImport) throws IOException {
        List<CsvEvent> csvEvents = eventFileParserPort.parse(fileToImport.getInputStream());

        eventServicePort.importEvents(csvEvents);
    }

    @GetMapping("/upcoming")
    public List<EventDto> getUpcomingEvents() {
        return eventMapper.mapToDtoList(eventServicePort.getUpcomingEvents());
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportEvents() {
        InputStreamResource fileToExport = new InputStreamResource(new ByteArrayInputStream(eventServicePort.exportEvents()));

        return ResponseEntity.ok()
                .header(CONTENT_DISPOSITION, "attachment;filename=events.csv")
                .contentType(MediaType.parseMediaType("text/csv;charset=UTF-8"))
                .body(fileToExport);
    }

}
