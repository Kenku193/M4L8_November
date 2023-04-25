package org.example;

import org.example.dataSource.HikariCPDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PoolUsingExample {
    public static void main(String[] args) throws SQLException {
        String template = "INSERT INTO usersM4L8(id, name, age) VALUES (?, ?, ?);";

        // ПОСМОТРИ НА КЛАСС HikariCPDataSource - МЫ ПОЛУЧАЕМ КОННЕКШЕНЫ ОТ ОБЪЕКТА ds - ИЗУЧИ ЕГО, ЭТО И ЕСТЬ ПУЛ
        try (Connection connection = HikariCPDataSource.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(template);

            preparedStatement.setInt(1, 1000);
            preparedStatement.setString(2, "JavaRush");
            preparedStatement.setInt(3, 14);

            preparedStatement.executeUpdate();
        }
    }
}
