package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.adapter;

import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.TalkRepositoryPort;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.TalkEntity;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.mapper.TalkMapper;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.repository.TalkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO 3 : Implement adapter by using corresponding Port
@Service
@RequiredArgsConstructor
public class TalkRepositoryAdapter {

    private final TalkRepository talkRepository;

    private final TalkMapper talkMapper;

    // TODO 4 : Request repository => findAllOrderedByDate()

}
