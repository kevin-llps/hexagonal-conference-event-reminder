package fr.kevin.llps.conf.event.reminder.bootstrap.config;

import fr.kevin.llps.conf.event.reminder.domain.ports.client.EventFileParserPort;
import fr.kevin.llps.conf.event.reminder.domain.ports.client.EventServicePort;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.AttendeeRepositoryPort;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.BBLRepositoryPort;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.PracticeSessionRepositoryPort;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.TalkRepositoryPort;
import fr.kevin.llps.conf.event.reminder.domain.service.*;
import fr.kevin.llps.conf.event.reminder.domain.utils.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.ZoneId;

@Configuration
public class AppConfiguration {

    @Bean
    public Clock clock(@Value("${conf.event.reminder.default.time-zone}") String defaultTimeZone) {
        return Clock.system(ZoneId.of(defaultTimeZone));
    }

    @Bean
    public EventFileParserPort eventFileParserPort() {
        return new EventFileParser();
    }

    @Bean
    public DateUtils dateUtils(Clock clock) {
        return new DateUtils(clock);
    }

    @Bean
    public TalkService talkService(TalkRepositoryPort talkRepositoryPort, DateUtils dateUtils) {
        return new TalkService(talkRepositoryPort, dateUtils);
    }

    @Bean
    public BBLService bblService(BBLRepositoryPort bblRepositoryPort, DateUtils dateUtils) {
        return new BBLService(bblRepositoryPort, dateUtils);
    }

    @Bean
    public PracticeSessionService practiceSessionService(PracticeSessionRepositoryPort practiceSessionRepositoryPort,
                                                         AttendeeRepositoryPort attendeeRepositoryPort,
                                                         DateUtils dateUtils) {
        return new PracticeSessionService(practiceSessionRepositoryPort, attendeeRepositoryPort, dateUtils);
    }

    @Bean
    public EventServicePort eventServicePort(TalkService talkService,
                                             BBLService bblService,
                                             PracticeSessionService practiceSessionService) {
        return new EventService(talkService, bblService, practiceSessionService);
    }

}
