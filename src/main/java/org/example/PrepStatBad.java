package org.example;

import org.example.dataSource.ConnectionData;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepStatBad {
    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionData.getConnection();
        Statement statement = connection.createStatement();

       String sql = getQuery("usersM4L8", 100, "Theo", 54);

       statement.executeUpdate(sql);
       connection.close();

    }

    public static String getQuery(String table, int id, String name, int age){
        String query = "INSERT INTO " +
                                        table
                                        + "(id, name, age) VALUE "
                                        + "(" + id + ", '" + name + "', " + age + ");";

        return query;
    }
}
