package fr.kevin.llps.conf.event.reminder.api.rest.utils;

import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class TestUtils {

    public static final LocalDateTime DATE = LocalDateTime.of(2022, 10, 13, 20, 59, 0);

    public static String readResource(Resource resource) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }

}
