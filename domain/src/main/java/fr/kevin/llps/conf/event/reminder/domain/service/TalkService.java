package fr.kevin.llps.conf.event.reminder.domain.service;

import fr.kevin.llps.conf.event.reminder.domain.DateUtils;
import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.TalkRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class TalkService {

    private final TalkRepositoryPort talkRepositoryPort;
    private final DateUtils dateUtils;

    public void importTalks(List<Talk> talks) {
        talkRepositoryPort.saveAll(talks);
    }

    public List<Talk> getUpcomingTalks() {
        LocalDateTime currentDate = dateUtils.getCurrentDate();

        return talkRepositoryPort.findByDateLaterThan(currentDate);
    }

    public List<Talk> getAll() {
        return talkRepositoryPort.findAllOrderedByDate();
    }

}
