package fr.kevin.llps.conf.event.reminder.domain.service;

import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import fr.kevin.llps.conf.event.reminder.domain.ports.client.TalkServicePort;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.TalkRepositoryPort;

import java.util.List;

public class TalkService implements TalkServicePort {

    // TODO 2 : Request Database adapter (Port)

    @Override
    public List<Talk> getTalks() {
        return null;
    }

}
