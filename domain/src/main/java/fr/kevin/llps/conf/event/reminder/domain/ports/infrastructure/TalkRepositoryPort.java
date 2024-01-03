package fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure;

import fr.kevin.llps.conf.event.reminder.domain.model.Talk;

import java.time.LocalDateTime;
import java.util.List;

public interface TalkRepositoryPort {

    void saveAll(List<Talk> talks);

    List<Talk> findByDateLaterThan(LocalDateTime date);

    List<Talk> findAllOrderedByDate();

}
