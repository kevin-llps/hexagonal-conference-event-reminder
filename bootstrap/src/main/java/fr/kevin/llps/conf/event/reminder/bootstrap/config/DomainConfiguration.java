package fr.kevin.llps.conf.event.reminder.bootstrap.config;


import fr.kevin.llps.conf.event.reminder.domain.DateUtils;
import fr.kevin.llps.conf.event.reminder.domain.ddd.DomainService;
import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.time.Clock;
import java.time.ZoneId;


@Configuration
@ComponentScan(
        basePackageClasses = {DateUtils.class},
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {DomainService.class})})
public class DomainConfiguration {

    @Bean
    public Clock clock(@Value("${conf.event.reminder.default.time-zone}") String defaultTimeZone) {
        return Clock.system(ZoneId.of(defaultTimeZone));
    }
}



