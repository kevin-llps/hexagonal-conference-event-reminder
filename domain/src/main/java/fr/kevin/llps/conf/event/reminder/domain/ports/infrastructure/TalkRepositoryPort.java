package fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure;

import fr.kevin.llps.conf.event.reminder.domain.model.Talk;

import java.util.List;

public interface TalkRepositoryPort {

    List<Talk> findAllOrderedByDate();

}
