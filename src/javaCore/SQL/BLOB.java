package javaCore.SQL;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

/**
 * BLOB CLOB - представление картинок и текста в SQL таблицах
 *
 * @author Ross Khapilov
 * @version 1.0 18.02.2019
 */
public class BLOB {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        String username = "root";
        String password = "pass";
        String connectionURL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, username, password); Statement statement = connection.createStatement()) {
            System.out.println("we are connected");
            statement.execute("DROP TABLE IF EXISTS BLOBtest");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS  BLOBtest (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, img BLOB, PRIMARY KEY (id))");

            BufferedImage image = ImageIO.read(new File("D:\\prog\\MyProjects\\Learning\\src\\javaCore\\SQL\\tux.jpg"));
            Blob blob = connection.createBlob();
            try (OutputStream outputStream = blob.setBinaryStream(1)) {
                ImageIO.write(image, "jpg", outputStream);
            }

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO BLOBtest (name, img) values (?,?)");
            preparedStatement.setString(1, "Legushka");
            preparedStatement.setBlob(2, blob);
            preparedStatement.execute();

            //теперь прочитаем картинку из таблицы
            ResultSet resultSet = statement.executeQuery("SELECT * FROM blobtest");
            while(resultSet.next()){
                Blob blob2 = resultSet.getBlob("img");
                BufferedImage image2 = ImageIO.read(blob2.getBinaryStream());
                File outputfile = new File("D:\\prog\\MyProjects\\Learning\\src\\javaCore\\SQL\\saved.png");
                ImageIO.write(image2,"png",outputfile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
