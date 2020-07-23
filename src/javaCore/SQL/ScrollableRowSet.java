package javaCore.SQL;

import java.sql.*;

/**
 * @author Ross Khapilov
 * @version 1.0 22.02.2019
 */
public class ScrollableRowSet {
    public static void main(String[] args) throws ClassNotFoundException {
        String username = "root";
        String password = "pass";
        String connectionURL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, username, password)) {
            Statement stat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = stat.executeQuery("SELECT * FROM Books");

            //идем в одну сторону
            if(resultSet.next())
                System.out.println(resultSet.getString("name"));
            if(resultSet.next())
                System.out.println(resultSet.getString("name"));

            //идем в обратную сторону
            if(resultSet.previous())
                System.out.println(resultSet.getString("name"));

            //на сколько колонок сдвигаемся
            if(resultSet.relative(3))
                System.out.println(resultSet.getString("name"));
            if(resultSet.relative(-2))
                System.out.println(resultSet.getString("name"));

            //абсолютный номер строчки
            if(resultSet.absolute(5))
                System.out.println(resultSet.getString("name"));

            //вывод самых первых и последних строк
            if(resultSet.first())
                System.out.println(resultSet.getString("name"));
            if(resultSet.last())
                System.out.println(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
