package org.example;

import org.example.dataSource.ConnectionData;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RowSetExample {
    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionData.getConnection();
        Statement statement = connection.createStatement();

        try {
            ResultSet resultSet = statement.executeQuery(SQLCommands.mySQLSelectAllFromTable);

            RowSetFactory rowSetFactory = RowSetProvider.newFactory();
            CachedRowSet cachedRowSet = rowSetFactory.createCachedRowSet();

            cachedRowSet.populate(resultSet);
            connection.close();

            // КОННЕКШЕН ЗАКРЫЛИ, А РОУСЕТ ПОЛОН ДАННЫХ И С НИМ МОЖНО РАБОТАТЬ

            while (cachedRowSet.next()) {
                int id = cachedRowSet.getInt("id");
                String name = cachedRowSet.getString("name");
                int age = cachedRowSet.getInt("age");
                System.out.printf("%-4d %-10s %-2d \n", id, name, age);

            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();

        jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/Data");
        jdbcRowSet.setUsername("root");
        jdbcRowSet.setPassword("qwerty");

        jdbcRowSet.setCommand(SQLCommands.mySQLSelectAllFromTable);
        jdbcRowSet.execute();

        while (jdbcRowSet.next()) {
            int id = jdbcRowSet.getInt("id");
            String name = jdbcRowSet.getString("name");
            int age = jdbcRowSet.getInt("age");
            System.out.printf("%-4d %-10s %-2d \n", id, name, age);


        }
    }
}

