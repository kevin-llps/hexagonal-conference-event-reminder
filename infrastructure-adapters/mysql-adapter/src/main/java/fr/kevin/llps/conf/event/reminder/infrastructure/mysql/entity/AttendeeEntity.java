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
@Table(name = "attendee")
public class AttendeeEntity {

    @Id
    @GeneratedValue
    @Column(name = "attendee_id", nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(name = "firstname", nullable = false, columnDefinition = "VARCHAR(100)")
    private String firstname;
    @Column(name = "lastname", nullable = false, columnDefinition = "VARCHAR(100)")
    private String lastname;
    @OneToMany(mappedBy = "attendee", cascade = ALL)
    private List<PracticeSessionAttendeeEntity> practiceSessionAttendees;

    public AttendeeEntity(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstname, lastname);
    }
}
