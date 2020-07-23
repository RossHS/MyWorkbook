package javaCore.SQL;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

/**
 * Работа с закрытым соединением из кеша и последующие изменения в БД из кеша
 *
 * @author Ross Khapilov
 * @version 1.0 22.02.2019
 */
public class CachedRowSetTest {
    private static String username = "root";
    private static String password = "pass";
    private static String connectionURL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ResultSet resultSet = getResultSet();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString("name"));
        }
        System.out.println("----------------------");
    }


    public static ResultSet getResultSet() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, username, password)) {
            Statement statement = connection.createStatement();
            //напрямую так вернуть нельзя т.к. данные получаются по открытому соединению,
            // которое закрывается после выхода из тела метода, это можно исправить использую кэширование
            ResultSet resultSet = statement.executeQuery("SELECT * FROM test.books");

            //кэшируем полученный результат и уже его возвращаем обратно
            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet cachedRowSet = factory.createCachedRowSet();
            cachedRowSet.populate(resultSet);

            return cachedRowSet;
        }
    }
}
