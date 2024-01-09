package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.adapter;

import fr.kevin.llps.conf.event.reminder.domain.model.Speaker;
import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//TODO 1 : Implement Port
@Service
public class MySQLDatabaseService {

    private static final String SELECT_TALKS = "SELECT t.date, t.title, " +
            "t.description, s.firstname, s.lastname " +
            "FROM talk t JOIN speaker s " +
            "ON t.speaker_id = s.speaker_id " +
            "ORDER BY t.date;";

    private final MySQLDatabaseConnectionService connectionService;

    public MySQLDatabaseService(MySQLDatabaseConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @Override
    public List<Talk> findAllOrderedByDate() {
        try (Connection connection = connectionService.openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TALKS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            List<Talk> talks = new ArrayList<>();

            while (resultSet.next()) {
                LocalDateTime date = LocalDateTime.parse(resultSet.getString(1), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                String speakerFirstname = resultSet.getString(4);
                String speakerLastname = resultSet.getString(5);

                Speaker speaker = new Speaker(speakerFirstname, speakerLastname);

                talks.add(new Talk(title, description, date, speaker));
            }

            return talks;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
