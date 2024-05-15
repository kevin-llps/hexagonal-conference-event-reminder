package fr.kevin.llps.conf.event.reminder.domain.service;

import fr.kevin.llps.conf.event.reminder.domain.DateUtils;
import fr.kevin.llps.conf.event.reminder.domain.ddd.DomainService;
import fr.kevin.llps.conf.event.reminder.domain.model.BBL;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.BBLRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@DomainService
@RequiredArgsConstructor
public class BBLService {

    private final BBLRepositoryPort bblRepositoryPort;
    private final DateUtils dateUtils;

    public void importBBLs(List<BBL> bblList) {
        bblRepositoryPort.saveAll(bblList);
    }

    public List<BBL> getUpcomingBBLs() {
        LocalDateTime currentDate = dateUtils.getCurrentDate();

        return bblRepositoryPort.findByDateLaterThan(currentDate);
    }

    public List<BBL> getAll() {
        return bblRepositoryPort.findAllOrderedByDate();
    }
}
