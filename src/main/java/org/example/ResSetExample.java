package org.example;

import org.example.dataSource.ConnectionData;

import java.sql.*;

public class ResSetExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionData.getConnection();
        Statement statement = connection.createStatement();

        try {
            ResultSet resultSet = statement.executeQuery(SQLCommands.mySQLSelectAllFromTable);

            //  connection.close();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.printf("%-4d %-10s %-2d \n", id, name, age);
            }

        }

        catch(SQLException e){
            throw new RuntimeException();
        }

    }
}
