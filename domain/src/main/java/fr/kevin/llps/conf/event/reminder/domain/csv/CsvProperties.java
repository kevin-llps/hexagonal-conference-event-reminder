package fr.kevin.llps.conf.event.reminder.domain.csv;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CsvProperties {

    public static final char DELIMITER = ';';

    public static final String[] HEADERS = {"titre", "type", "description", "date", "heure", "conférencier", "participants", "entreprise"};

}
