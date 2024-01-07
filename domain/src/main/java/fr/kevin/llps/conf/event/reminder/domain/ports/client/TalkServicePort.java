package fr.kevin.llps.conf.event.reminder.domain.ports.client;

import fr.kevin.llps.conf.event.reminder.domain.model.Talk;

import java.util.List;

public interface TalkServicePort {

    List<Talk> getTalks();

}
