package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@Data
@NoArgsConstructor
@Entity
@Table(name = "speaker")
public class SpeakerEntity {

    public SpeakerEntity(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Id
    @GeneratedValue
    @Column(name = "speaker_id", nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "firstname", nullable = false, columnDefinition = "VARCHAR(100)")
    private String firstname;

    @Column(name = "lastname", nullable = false, columnDefinition = "VARCHAR(100)")
    private String lastname;

    @OneToMany(mappedBy = "speaker", cascade = ALL)
    private List<TalkEntity> talks;

    @OneToMany(mappedBy = "speaker", cascade = ALL)
    private List<BBLEntity> bbls;

    @OneToMany(mappedBy = "speaker", cascade = ALL)
    private List<PracticeSessionEntity> practiceSessions;

}
