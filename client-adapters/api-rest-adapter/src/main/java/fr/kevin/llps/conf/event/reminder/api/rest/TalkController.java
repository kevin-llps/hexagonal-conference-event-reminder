package fr.kevin.llps.conf.event.reminder.api.rest;

import fr.kevin.llps.conf.event.reminder.api.rest.dto.TalkDto;
import fr.kevin.llps.conf.event.reminder.api.rest.mapper.TalkDtoMapper;
import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import fr.kevin.llps.conf.event.reminder.domain.ports.client.TalkServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/talks")
@RequiredArgsConstructor
public class TalkController {

    private final TalkServicePort talkServicePort;
    private final TalkDtoMapper talkMapper;

    @GetMapping
    public List<TalkDto> getTalks() {
        List<Talk> talks = talkServicePort.getTalks();

        return talkMapper.mapToDtoList(talks);
    }

}
