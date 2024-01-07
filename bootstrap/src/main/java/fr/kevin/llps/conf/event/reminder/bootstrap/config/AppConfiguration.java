package fr.kevin.llps.conf.event.reminder.bootstrap.config;

import fr.kevin.llps.conf.event.reminder.domain.ports.client.TalkServicePort;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.TalkRepositoryPort;
import fr.kevin.llps.conf.event.reminder.domain.service.TalkService;
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
    public TalkServicePort talkServicePort(TalkRepositoryPort talkRepositoryPort) {
        return new TalkService(talkRepositoryPort);
    }

}
