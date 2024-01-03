package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.adapter;

import fr.kevin.llps.conf.event.reminder.domain.model.BBL;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.BBLEntity;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.mapper.BBLMapper;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.repository.BBLRepository;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.BBLRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BBLRepositoryAdapter implements BBLRepositoryPort {

    private final BBLRepository bblRepository;

    private final BBLMapper bblMapper;

    @Override
    public void saveAll(List<BBL> bblList) {
        List<BBLEntity> bblEntities = bblMapper.mapToEntities(bblList);

        bblRepository.saveAll(bblEntities);
    }

    @Override
    public List<BBL> findByDateLaterThan(LocalDateTime date) {
        List<BBLEntity> bblEntities = bblRepository.findByDateLaterThan(date);

        return bblMapper.mapToDomain(bblEntities);
    }

    @Override
    public List<BBL> findAllOrderedByDate() {
        List<BBLEntity> bblEntities = bblRepository.findAllOrderedByDate();

        return bblMapper.mapToDomain(bblEntities);
    }

}
