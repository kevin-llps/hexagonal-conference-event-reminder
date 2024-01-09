package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.adapter;

import fr.kevin.llps.conf.event.reminder.domain.model.Talk;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MySQLDatabaseServiceTest {

    @Mock
    private MySQLDatabaseConnectionService databaseService;

    @InjectMocks
    private MySQLDatabaseService mySQLDatabaseAdapter;

    @Test
    void shouldGetTalks() throws SQLException {
        Connection connection = mock(Connection.class);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        ResultSet resultSet = mock(ResultSet.class);

        when(databaseService.openConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        when(resultSet.getString(1)).thenReturn("2023-02-05 19:00:00").thenReturn("2023-06-28 19:00:00");
        when(resultSet.getString(2)).thenReturn("conf1").thenReturn("conf2");
        when(resultSet.getString(3)).thenReturn("Description conf1").thenReturn("Description conf2");
        when(resultSet.getString(4)).thenReturn("jean").thenReturn("alice");
        when(resultSet.getString(5)).thenReturn("dupont").thenReturn("dupont");

        List<Talk> talks = mySQLDatabaseAdapter.findAllOrderedByDate();

        assertThat(talks).isNotNull()
                .hasSize(2)
                .extracting("title", "description", "date", "speaker.firstname", "speaker.lastname")
                .containsExactlyInAnyOrder(
                        tuple("conf1",
                                "Description conf1",
                                LocalDateTime.of(2023, 2, 5, 19, 0, 0),
                                "jean", "dupont"),
                        tuple("conf2",
                                "Description conf2",
                                LocalDateTime.of(2023, 6, 28, 19, 0, 0),
                                "alice", "dupont"));

        verifyNoMoreInteractions(databaseService);
    }

}
