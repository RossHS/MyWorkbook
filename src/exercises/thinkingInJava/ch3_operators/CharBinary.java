package thinkingInJava.ch3_operators;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 30.12.2017
 */
public class CharBinary {
    public static int charToBinary(char a) {
        String bin = Integer.toBinaryString(a);
        return Integer.parseInt(bin);
    }

    public static void main(String[] args) {
        System.out.println('a');
        System.out.println(charToBinary('a'));
        System.out.println(5 >> 1);
    }
}
