package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.repository;

import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.AttendeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttendeeRepository extends JpaRepository<AttendeeEntity, UUID> {

}
