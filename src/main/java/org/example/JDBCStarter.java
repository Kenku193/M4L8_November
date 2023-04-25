package org.example;

import org.example.dataSource.ConnectionData;
import org.example.dataSource.HikariCPDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStarter {
    public static void main(String[] args) {

        execute(SQLCommands.mySQLCreateTable);
        execute(SQLCommands.mySQLInsertUserToUsers);
        int i = executeUpdate(SQLCommands.mySQLInsertManyUsers);
        System.out.println(i);
        printAll(SQLCommands.mySQLSelectAllFromTable);

    }

    private static void execute(String sql) {
        try {
            Connection connection = ConnectionData.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);

            //  statement.close();
            //  connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static int executeUpdate(String sql) {
        try {
            Connection connection = ConnectionData.getConnection();
            Statement statement = connection.createStatement();
            int countModified = statement.executeUpdate(sql); // ВОЗВРАЩАЕТ ЧИСЛОВОЕ ПРЕДСТАВЛЕНИЕ ИЗМЕНЕНИЙ
            return countModified;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printAll(String sql) { // SELECT *
        //users - id(int) name(String) age(int)
        try {
            Connection connection = ConnectionData.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql); // ВОЗВРАЩАЕТ РЕЗУЛЬТИРУЮЩИЙ НАБОР ДАННЫХ ПОСТРОЧНО

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.printf("%-4d %-10s %-2d \n", id, name, age);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}