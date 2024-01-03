package fr.kevin.llps.conf.event.reminder.domain.model;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class EventType {
    public static final String TALK = "Talk";
    public static final String BBL = "BBL";
    public static final String PRACTICE_SESSION = "Session pratique";
}
