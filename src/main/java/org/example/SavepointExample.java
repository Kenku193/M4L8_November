package org.example;

import org.example.dataSource.ConnectionData;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavepointExample {

    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionData.getConnection();
        Statement statement = connection.createStatement();

    //    statement.execute(SQLCommands.mySQLCreateTable);
        connection.setAutoCommit(false);

        statement.executeUpdate("INSERT INTO usersM4L8(id, name, age) VALUE (33, 'Al Powell', 43)");
        statement.executeUpdate("INSERT INTO usersM4L8(id, name, age) VALUE (44, 'Karl', 34)");
        connection.commit();
        Savepoint savepoint = connection.setSavepoint();

        try {

            statement.executeUpdate("INSERT INTO usersM4L8(id, name, age) VALUE (11, 'John McClane', 39)");
            statement.executeUpdate("INSERT INTO usersM4L8(id, name, age) VALUE (22, 'Holly Gennero', 35)");
            statement.executeUpdate("INSERT INTO usersM4L(id, name, age) VALUE (33, 'Severus Snape as Hans Gruber', 43)");

            connection.commit();

        }
        catch (SQLException e){
            connection.rollback(savepoint);
        }

        connection.close();

    }

}
