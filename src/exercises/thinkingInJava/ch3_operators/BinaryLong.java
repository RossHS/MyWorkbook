package thinkingInJava.ch3_operators;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 20.12.2017
 */
public class BinaryLong {
    public static void main(String[] args) {
        long a = 0177L;
        long b = 0x11L;
        System.out.println(Long.toBinaryString(a));
        System.out.println(Long.toBinaryString(b));
    }
}
