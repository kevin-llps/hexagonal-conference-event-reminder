package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.adapter;

public record DatabaseSecret(String username,
                             String password,
                             String engine,
                             String dbname,
                             String host,
                             String port) {

}
