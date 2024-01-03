package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.repository;

import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity.BBLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface BBLRepository extends JpaRepository<BBLEntity, UUID> {

    @Query(value = "SELECT * FROM bbl b WHERE b.date >= :date ORDER BY b.date DESC", nativeQuery = true)
    List<BBLEntity> findByDateLaterThan(@Param("date") LocalDateTime date);

    @Query(value = "SELECT * FROM bbl b ORDER BY b.date", nativeQuery = true)
    List<BBLEntity> findAllOrderedByDate();

}
