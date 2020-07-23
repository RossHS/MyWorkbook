package javaCore.SQL;

import java.sql.*;

/**
 * Injection (инъекции) - Способ атаки на базы данных, когда подставляют неверные запросы на выполнение,
 * опасная вещь, есть от них не защититься, то благодаря им левые люди могут получить абсолютно любые данные из таблицы
 *
 * @author Ross Khapilov
 * @version 1.0 18.02.2019
 */
public class SQLInjection {
    public static void main(String[] args) throws ClassNotFoundException {
        String username = "root";
        String password = "pass";
        String connectionURL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, username, password); Statement statement = connection.createStatement()) {
            String bookId = "1' or 1 = '1";
            ResultSet resultSet = statement.executeQuery("SELECT * FROM test.books where  id = '" + bookId + "'");

            System.out.println("без защиты");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
            System.out.println("Получаем все данные, т.к. отсутствует защита");
            System.out.println("--------- \nс защитой");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  test.books where id = ?");
            preparedStatement.setString(1,bookId);
            ResultSet resultSet1 = preparedStatement.executeQuery();
            while(resultSet1.next()){
                System.out.println(resultSet1.getString(1) + " " + resultSet1.getString(2));
            }

            System.out.println("Таким образом не получилось обойти защиту");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
