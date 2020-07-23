package javaCore.SQL;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

/**
 * Чтобы выполнить данную тестовую программу, запустите сначала базу данных, как описано выше, а затем саму программу,
 * введя приведенную ниже команду. (Как всегда, пользователям Windows следует ввести точку с запятой (;) вместо
 * двоеточия (:) для разделения составляющих пути к файлу.)
 * java -classpath .;driverJAR test.TestDB
 *
 * @author Ross Khapilov
 * @version 1.0 28.01.2019
 */
public class TestDB {
    public static void main(String[] args) {
        try {
            runTest();
        } catch (SQLException e) {
            for (Throwable t : e)
                t.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Выполняет тест, создавая таблицу, вводя в нее значение, отображая содержимое таблицы и в конце удаляя его
     */
    public static void runTest() throws SQLException, IOException {
        try (Connection conn = getConnection(); Statement stat = conn.createStatement()) {
            stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
            stat.executeUpdate("INSERT INTO Greetings VALUES ('Hello, World')");

            try (ResultSet result = stat.executeQuery("SELECT * FROM Greetings")) {
                if (result.next())
                    System.out.println(result.getString(1));
            }
            stat.executeUpdate("DROP TABLE Greetings");
        }
    }

    /**
     * Получает соединение с базой данных из свойств, определяемых в файле database.properties
     *
     * @return Подключение к БД
     */
    public static Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("D:\\prog\\DataBase\\database.properties"))) {
            props.load(in);
        }
        String drivers = props.getProperty("jdbc.drivers");
        if (drivers != null) System.setProperty("jdbc.drivers", drivers);
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, username, password);
    }

}
