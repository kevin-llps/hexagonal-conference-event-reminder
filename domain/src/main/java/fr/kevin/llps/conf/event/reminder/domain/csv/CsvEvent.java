package fr.kevin.llps.conf.event.reminder.domain.csv;

import lombok.Builder;

@Builder
public record CsvEvent(String title,
                       String type,
                       String description,
                       String date,
                       String time,
                       String speaker,
                       String attendees,
                       String company) {
}

