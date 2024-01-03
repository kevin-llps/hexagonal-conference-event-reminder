package fr.kevin.llps.conf.event.reminder.api.rest.mapper;

import fr.kevin.llps.conf.event.reminder.domain.model.BBL;
import fr.kevin.llps.conf.event.reminder.domain.model.Event;
import fr.kevin.llps.conf.event.reminder.domain.model.PracticeSession;
import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import fr.kevin.llps.conf.event.reminder.api.rest.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static fr.kevin.llps.conf.event.reminder.domain.model.EventType.*;

@Component
@RequiredArgsConstructor
public class EventDtoMapper {

    private final TalkDtoMapper talkMapper;
    private final BBLDtoMapper bblMapper;
    private final PracticeSessionDtoMapper practiceSessionMapper;

    public List<EventDto> mapToDtoList(List<Event> events) {
        return events.stream()
                .map(this::mapToDto)
                .toList();
    }

    private EventDto mapToDto(Event event) {
        switch (event.getEventType()) {
            case TALK -> {
                return talkMapper.mapToDto((Talk) event);
            }
            case BBL -> {
                return bblMapper.mapToDto((BBL) event);
            }
            case PRACTICE_SESSION -> {
                return practiceSessionMapper.mapToDto((PracticeSession) event);
            }
        }
        return null;
    }

}
