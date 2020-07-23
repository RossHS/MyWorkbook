package javaCore.network;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Пример сокетного подключения с атомными часами в г. Боулдере, шт. Колорадо
 * и выводится время, передаваемое из сервера
 *
 * @author Ross Khapilov
 * @version 1.0 14.01.2019
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("time.nist.gov", 13);
             Scanner in = new Scanner(s.getInputStream(), StandardCharsets.UTF_8)) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}
