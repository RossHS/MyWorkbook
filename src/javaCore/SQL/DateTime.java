package javaCore.SQL;

import java.sql.*;

/**
 * Внос времени и даты в базу данных
 *
 * @author Ross Khapilov
 * @version 1.0 20.02.2019
 */
public class DateTime {
    public static void main(String[] args) throws ClassNotFoundException {
        String username = "root";
        String password = "pass";
        String connectionURL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, username, password); Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS DateTest");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS  DateTest (dt DATE, t TIME)");

            PreparedStatement preparedStatement = connection.prepareStatement("insert into DateTest values (?,?)");
            preparedStatement.setDate(1, new Date(System.currentTimeMillis()));
            preparedStatement.setTime(2, new Time(System.currentTimeMillis()));
            preparedStatement.execute();
            System.out.println(preparedStatement);

            statement.executeUpdate("insert into DateTest values({d '2019-02-19'},{t '17:40:15'})");

            ResultSet resultSet = statement.executeQuery("select * from DateTest");
            while (resultSet.next()) {
                System.out.println(resultSet.getDate(1));
                System.out.println(resultSet.getTime(2)+"\n");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
