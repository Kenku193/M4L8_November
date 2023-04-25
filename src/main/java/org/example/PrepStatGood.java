package org.example;

import org.example.dataSource.ConnectionData;

import java.sql.*;

public class PrepStatGood {
    public static void main(String[] args) throws SQLException {


        String template = "INSERT INTO usersM4L8(id, name, age) VALUES (?, ?, ?);";

        Connection connection = ConnectionData.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(template);

        Integer a = 9999;

        preparedStatement.setInt(1, a);
        preparedStatement.setString(2, "Argyle");
        preparedStatement.setInt(3, 76);

        preparedStatement.executeUpdate();



        connection.close();

    }
}
