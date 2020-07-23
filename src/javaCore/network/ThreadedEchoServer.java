package javaCore.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * В этой программе реализуется многопоточный сервер,
 * прослушивающий порт 8189 и передающий обратно все данные,
 * полученные от клиентов
 *
 * @author Ross Khapilov
 * @version 1.0 15.01.2019
 */
public class ThreadedEchoServer {
    public static void main(String[] args) {
        try (ServerSocket s = new ServerSocket(8189)) {
            int i = 1;
            while (true) {
                Socket incoming = s.accept();
                System.out.println("Spawning " + i);
                Runnable r = new ThreadedEchoHandler(incoming);
                new Thread(r).start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * Класс обрабатывает данные, получаемые сервером от
 * клиента через одно сокетное соединение
 */
class ThreadedEchoHandler implements Runnable {
    private Socket incoming;

    public ThreadedEchoHandler(Socket incoming) {
        this.incoming = incoming;
    }

    @Override
    public void run() {
        try (InputStream inStream = incoming.getInputStream();
             OutputStream outStream = incoming.getOutputStream()) {
            Scanner in = new Scanner(inStream, StandardCharsets.UTF_8);
            PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, StandardCharsets.UTF_8), true);

            out.println("Hello! Enter BYE to exit.");

            //передать обратно данные, полученные от клиента
            boolean done = false;
            while (!done && in.hasNextLine()) {
                String line = in.nextLine();
                out.println("Echo: " + line);
                if (line.trim().equals("BYE")) done = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
