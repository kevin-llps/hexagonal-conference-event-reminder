package fr.kevin.llps.conf.event.reminder.domain.service;

import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import fr.kevin.llps.conf.event.reminder.domain.ports.client.TalkServicePort;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.TalkRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TalkService implements TalkServicePort {

    private final TalkRepositoryPort talkRepositoryPort;

    public List<Talk> getTalks() {
        return talkRepositoryPort.findAllOrderedByDate();
    }

}
