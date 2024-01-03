package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.adapter;

import fr.kevin.llps.conf.event.reminder.domain.model.Attendee;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.AttendeeEntity;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.mapper.AttendeeMapper;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.repository.AttendeeRepository;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.AttendeeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendeeRepositoryAdapter implements AttendeeRepositoryPort {

    private final AttendeeRepository attendeeRepository;

    private final AttendeeMapper attendeeMapper;

    @Override
    public void saveAll(List<Attendee> attendees) {
        List<AttendeeEntity> attendeeEntities = attendeeMapper.mapToEntities(attendees);

        attendeeRepository.saveAll(attendeeEntities);
    }

}
