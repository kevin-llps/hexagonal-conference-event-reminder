package fr.kevin.llps.conf.event.reminder.bootstrap.config;

import fr.kevin.llps.conf.event.reminder.domain.ports.client.TalkServicePort;
import fr.kevin.llps.conf.event.reminder.domain.ports.infrastructure.TalkRepositoryPort;
import fr.kevin.llps.conf.event.reminder.domain.service.TalkService;
import fr.kevin.llps.conf.event.reminder.infrastructure.mysql.adapter.DatabaseSecret;
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
    public DatabaseSecret databaseSecret(@Value("${database.username}") String username,
                                         @Value("${database.password}") String password,
                                         @Value("${database.engine}") String engine,
                                         @Value("${database.dbname}") String dbname,
                                         @Value("${database.host}") String host,
                                         @Value("${database.port}") String port) {

        return new DatabaseSecret(username, password, engine, dbname, host, port);
    }

    @Bean
    public TalkServicePort talkServicePort(TalkRepositoryPort talkRepositoryPort) {
        return new TalkService(talkRepositoryPort);
    }

}
