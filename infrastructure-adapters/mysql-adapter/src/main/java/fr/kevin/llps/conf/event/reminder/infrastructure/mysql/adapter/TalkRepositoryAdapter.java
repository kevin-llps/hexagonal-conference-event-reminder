package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.adapter;

import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.TalkRepositoryPort;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.TalkEntity;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.mapper.TalkMapper;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.repository.TalkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TalkRepositoryAdapter implements TalkRepositoryPort {

    private final TalkRepository talkRepository;

    private final TalkMapper talkMapper;

    @Override
    public List<Talk> findAllOrderedByDate() {
        List<TalkEntity> talkEntities = talkRepository.findAllOrderedByDate();

        return talkMapper.mapToDomain(talkEntities);
    }

}
