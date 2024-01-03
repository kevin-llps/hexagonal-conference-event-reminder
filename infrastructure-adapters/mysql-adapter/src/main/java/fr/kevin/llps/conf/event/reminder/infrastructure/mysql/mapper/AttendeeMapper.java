package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.mapper;

import fr.kevin.llps.conf.event.reminder.domain.model.Attendee;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.AttendeeEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AttendeeMapper {

    public List<AttendeeEntity> mapToEntities(List<Attendee> attendees) {
        return attendees.stream()
                .map(this::mapToEntity)
                .toList();
    }

    private AttendeeEntity mapToEntity(Attendee attendee) {
        return new AttendeeEntity(attendee.firstname(), attendee.lastname());
    }

}
