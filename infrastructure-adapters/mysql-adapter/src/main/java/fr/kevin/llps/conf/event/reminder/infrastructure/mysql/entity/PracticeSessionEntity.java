package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@Data
@NoArgsConstructor
@Entity
@Table(name = "practice_session")
public class PracticeSessionEntity {

    @Id
    @GeneratedValue
    @Column(name = "practice_session_id", nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(name = "title", nullable = false, columnDefinition = "VARCHAR(100)")
    private String title;
    @Column(name = "description", nullable = false, columnDefinition = "VARCHAR(1000)")
    private String description;
    @Column(name = "date", nullable = false)
    private LocalDateTime date;
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "speaker_id")
    private SpeakerEntity speaker;
    @OneToMany(mappedBy = "practiceSession", cascade = ALL)
    private List<PracticeSessionAttendeeEntity> practiceSessionAttendees;

    public PracticeSessionEntity(String title, String description, LocalDateTime date, SpeakerEntity speaker) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.speaker = speaker;
    }

}
