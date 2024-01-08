package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.adapter;

import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.TalkRepositoryPort;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.mapper.TalkMapper;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.repository.TalkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class TalkRepositoryAdapter implements TalkRepositoryPort {

    private final TalkRepository talkRepository;

    private final TalkMapper talkMapper;

    public TalkRepositoryAdapter(TalkRepository talkRepository, TalkMapper talkMapper) {
        this.talkRepository = talkRepository;
        this.talkMapper = talkMapper;
    }

    @Override
    public List<Talk> findAllOrderedByDate() {
        // TODO : Request repository => findAllOrderedByDate()

        return null;
    }

}
