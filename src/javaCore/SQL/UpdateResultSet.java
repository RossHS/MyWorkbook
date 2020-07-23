package javaCore.SQL;

import java.sql.*;

/**
 * Изменение данных в БД "налету"
 *
 * @author Ross Khapilov
 * @version 1.0 22.02.2019
 */
public class UpdateResultSet {
    public static void main(String[] args) throws ClassNotFoundException {
        String username = "root";
        String password = "pass";
        String connectionURL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, username, password);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ResultSet resultSet = statement.executeQuery("select * from test.books");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "\t" + resultSet.getString("name"));
            }
            System.out.println("-------------");

            resultSet.last();
            resultSet.updateString("name","A SQL guide");
            resultSet.updateRow();

            resultSet.moveToInsertRow();
            resultSet.updateString("name","New Book about C#");
            resultSet.insertRow();

            resultSet.beforeFirst();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "\t" + resultSet.getString("name"));
            }
            System.out.println("********************");


            resultSet.last();
            resultSet.deleteRow();

            resultSet.beforeFirst();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "\t" + resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
