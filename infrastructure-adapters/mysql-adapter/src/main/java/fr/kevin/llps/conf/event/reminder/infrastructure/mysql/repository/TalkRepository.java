package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.repository;

import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.TalkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TalkRepository extends JpaRepository<TalkEntity, UUID> {

    @Query(value = "SELECT * FROM talk t ORDER BY t.date", nativeQuery = true)
    List<TalkEntity> findAllOrderedByDate();

}
