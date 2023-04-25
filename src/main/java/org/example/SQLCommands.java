package org.example;

public final class SQLCommands {
    public SQLCommands() {
    }

    public static final String mySQLCreateTable = "CREATE TABLE usersM4L8(id INT, name VARCHAR(128), age INT)";

    public static final String mySQLInsertUserToUsers = "INSERT INTO usersM4L8(id, name, age) VALUES (10, 'TEST', 53);";

    public static final String mySQLInsertManyUsers = """
            INSERT INTO usersM4L8(id, name, age) VALUES
                                                 (1, 'YURA', 35),
                                                 (2, 'Dima', 22),
                                                 (3, 'Petya', 99),
                                                 (4, 'Nicolas Flamel', 999);
            """
            ;

    public static final String mySQLSelectAllFromTable = "SELECT * FROM usersM4L8";

    public static final String mySQLDropTable = "DROP TABLE usersM4L8";
}
