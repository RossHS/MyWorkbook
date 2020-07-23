package javaCore.SQL;

import java.sql.*;

/**
 * Гарантия целостности выполнения запросов SQL, если одна из команд
 * не будет выполнена, произойдет "откат"
 *
 * @author Ross Khapilov
 * @version 1.0 22.02.2019
 */
public class TransactionsTest {
    public static void main(String[] args) throws ClassNotFoundException {
        String username = "root";
        String password = "pass";
        String connectionURL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, username, password);
             Statement statement = connection.createStatement()) {

            //отключаем автоматическое принятие команд
            connection.setAutoCommit(false);

            statement.executeUpdate("INSERT INTO test.books VALUES (20,'Java cook recipes')");
            //точка сохранения, до которой будет откатываться
            Savepoint savepoint = connection.setSavepoint();
            statement.executeUpdate("INSERT INTO test.books VALUES (21,'C++ cook recipes')");
            statement.executeUpdate("INSERT INTO test.books VALUES (22,'Python cook recipes')");

            connection.rollback(savepoint);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * обычно транзакции используют следующим образом
     */
    public static void example() throws ClassNotFoundException, SQLException {
        String username = "root";
        String password = "pass";
        String connectionURL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, username, password);
            Statement statement = connection.createStatement();
            //отключаем автоматическое принятие команд
            connection.setAutoCommit(false);
            statement.executeUpdate("INSERT INTO test.books VALUES (20,'Java cook recipes')");
            statement.executeUpdate("INSERT INTO test.books VALUES (21,'C++ cook recipes')");
            statement.executeUpdate("INSERT INTO test.books VALUES (22,'Python cook recipes')");
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        }
    }
}
