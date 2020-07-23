package javaCore.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * В этой программе реализуется простой сервер,
 * прослушивающий порт 8189 и посылающий
 *
 * @author Ross Khapilov
 * @version 1.0 15.01.2019
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        //установить сокет на стороне сервера
        try (ServerSocket s = new ServerSocket(8189)) {
            //ожидать подключения клиента
            try (Socket incoming = s.accept()) {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();

                try (Scanner in = new Scanner(inStream, StandardCharsets.UTF_8)) {
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, StandardCharsets.UTF_8), true);
                    out.println("Hello! Enter BYE to exit.");

                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if (line.trim().equals("BYE")) done = true;
                    }
                }
            }
        }
    }
}
