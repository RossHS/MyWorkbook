package javaCore.SQL;

import java.sql.*;

/**
 * Вызов хранимых процедур из базы данных
 *
 * @author Ross Khapilov
 * @version 1.0 22.02.2019
 */
public class Procedure {
    public static void main(String[] args) throws ClassNotFoundException {
        String username = "root";
        String password = "pass";
        String connectionURL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, username, password)) {

            // Вызов процедуры без передачи параметров
            CallableStatement callableStatement = connection.prepareCall("{call BooksCount(?)}");
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();
            System.out.println(callableStatement.getInt(1));
            System.out.println("-------------------");

            //с передачей параметров и получением данных из БД
            CallableStatement callableStatementBookById = connection.prepareCall("{call getBookById(?)}");
            callableStatementBookById.setInt(1, 3);
            if (callableStatementBookById.execute()) {
                ResultSet resultSet = callableStatementBookById.getResultSet();
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id") + "\t" + resultSet.getString("name"));
                }
            }
            System.out.println("-------------------");

            //вызов процедур с Множественными результатами
            CallableStatement callableStatementMulti = connection.prepareCall("{call getCount()}");
            boolean hasResult = callableStatementMulti.execute();
            while (hasResult) {
                ResultSet resultSet = callableStatementMulti.getResultSet();
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + "\tКоличество элементов в БД");
                }
                hasResult = callableStatementMulti.getMoreResults();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
