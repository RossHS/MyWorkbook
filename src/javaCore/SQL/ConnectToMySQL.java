package javaCore.SQL;

import java.sql.*;

/**
 * Первый делом для подключения надо нагуглить Class.forname для конкретной ДБ, скачать и подключить к проекту коннектор
 * URL же для бд всегда можно взять из самой Intellij
 *
 * @author Ross Khapilov
 * @version 1.0 29.01.2019
 */
public class ConnectToMySQL {
    public static void main(String[] args) throws ClassNotFoundException {
        String username = "root";
        String password = "pass";
        String connectionURL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, username, password); Statement statement = connection.createStatement()) {
            System.out.println("we are connected");
//            statement.executeUpdate("INSERT INTO test.books (name) values ('Python book')");
//            statement.executeUpdate("INSERT INTO test.books SET name = 'Java Best Practice'");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM test.books");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
