package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.adapter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MySQLDatabaseConnectionServiceTest {

    private static final DatabaseSecret DB_SECRET = new DatabaseSecret("tata", "password", "toto", "base", "localhost", "82");

    @Mock
    private Driver driver;

    private MySQLDatabaseConnectionService databaseService;

    @BeforeEach
    void setUp() throws SQLException {
        DriverManager.registerDriver(driver);

        databaseService = new MySQLDatabaseConnectionService(DB_SECRET);
    }

    @AfterEach
    void tearDown() throws SQLException {
        DriverManager.deregisterDriver(driver);
    }

    @Test
    void shouldOpenConnection() throws SQLException {
        String url = "jdbc:" + DB_SECRET.engine() + "://" + DB_SECRET.host() + ":" + DB_SECRET.port() + "/" +
                DB_SECRET.dbname();

        Properties info = new Properties();
        info.put("user", DB_SECRET.username());
        info.put("password", DB_SECRET.password());

        Connection expectedConnection = mock(Connection.class);
        when(driver.connect(url, info)).thenReturn(expectedConnection);

        Connection actualConnection = databaseService.openConnection();

        assertThat(actualConnection).isEqualTo(expectedConnection);

        verify(driver).connect(url, info);
        verify(expectedConnection).setAutoCommit(false);
    }

    @Test
    void openConnection_shouldThrowLambdaException_whenSqlExceptionIsThrown() throws SQLException {
        Properties info = new Properties();
        info.put("user", DB_SECRET.username());
        info.put("password", DB_SECRET.password());
        String url = "jdbc:" + DB_SECRET.engine() + "://" + DB_SECRET.host() + ":" + DB_SECRET.port() + "/" +
                DB_SECRET.dbname();

        Connection connection = mock(Connection.class);
        when(driver.connect(url, info)).thenReturn(connection);

        doThrow(new SQLException()).when(connection).setAutoCommit(false);

        doThrow(new SQLException()).when(connection).close();

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> databaseService.openConnection());

        verify(driver).connect(url, info);
        verify(connection).setAutoCommit(false);
        verify(connection).close();
    }

    @Test
    void openConnection_shouldNotCloseConnection_whenGetConnectionThrowException() throws SQLException {
        Properties info = new Properties();
        info.put("user", DB_SECRET.username());
        info.put("password", DB_SECRET.password());
        String url = "jdbc:" + DB_SECRET.engine() + "://" + DB_SECRET.host() + ":" + DB_SECRET.port() + "/" +
                DB_SECRET.dbname();

        when(driver.connect(url, info)).thenThrow(new SQLException());

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> databaseService.openConnection());

        verify(driver).connect(url, info);
    }

}
