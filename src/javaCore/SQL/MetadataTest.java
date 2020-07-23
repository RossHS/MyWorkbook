package javaCore.SQL;

import java.sql.*;

/**
 * Получение скрытой от конечного пользователя способы хранения данных в БД.
 *
 * @author Ross Khapilov
 * @version 1.0 22.02.2019
 */
public class MetadataTest {
    public static void main(String[] args) throws ClassNotFoundException {
        String username = "root";
        String password = "pass";
        String connectionURL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, username, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, null, new String[]{"Table"});
            while (resultSet.next()) {
                System.out.println(resultSet.getString(3));
            }

            System.out.println("-------------------------------");
            Statement statement = connection.createStatement();
            ResultSet resultSet1 = statement.executeQuery("select *from test.books");
            ResultSetMetaData resultSetMetaData = resultSet1.getMetaData();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.println(resultSetMetaData.getColumnLabel(i) + "\t" + resultSetMetaData.getColumnTypeName(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
