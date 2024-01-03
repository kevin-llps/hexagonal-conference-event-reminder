package fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure;

import fr.kevin.llps.conf.event.reminder.domain.model.BBL;

import java.time.LocalDateTime;
import java.util.List;

public interface BBLRepositoryPort {

    void saveAll(List<BBL> bblList);

    List<BBL> findByDateLaterThan(LocalDateTime date);

    List<BBL> findAllOrderedByDate();

}
