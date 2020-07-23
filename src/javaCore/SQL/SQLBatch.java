package javaCore.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQL Batch - отправление комманд на выполнение группой (пакетом), т.е. не надо для каждой команды каждый раз подключаться и отправлять по паре строк
 * таким образом получается сократить время исполнения команд.
 *
 * @author Ross Khapilov
 * @version 1.0 22.02.2019
 */
public class SQLBatch {
    public static void main(String[] args) throws ClassNotFoundException {
        String username = "root";
        String password = "pass";
        String connectionURL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, username, password);
             Statement statement = connection.createStatement()) {
            statement.addBatch("INSERT INTO test.books VALUES (23,'Java recipes')");
            statement.addBatch("INSERT INTO test.books VALUES (24,'C++ recipes')");
            statement.addBatch("INSERT INTO test.books VALUES (25,'Python recipes')");
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
