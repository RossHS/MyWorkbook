package javaCore.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * В этой программе демонстрируется применение класса InetAddress.
 * В качестве аргумента в командной строке следует указать имя
 * хоста или запустить программу без аргументов, чтобы получить
 * в ответ адрес локального хоста
 *
 * @author Ross Khapilov
 * @version 1.0 14.01.2019
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        if (args.length > 0) {
            for (String s : args) {
                InetAddress[] addresses = InetAddress.getAllByName(s);
                for (InetAddress a : addresses)
                    System.out.println(a);
            }
        } else {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);
        }
    }
}
