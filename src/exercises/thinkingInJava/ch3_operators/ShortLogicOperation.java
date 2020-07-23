package thinkingInJava.ch3_operators;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 19.12.2017
 */
public class ShortLogicOperation {
    static boolean test1(int val) {
        System.out.println("test1");
        return val < 1;
    }

    static boolean test2(int val) {
        System.out.println("test2");
        return val < 2;
    }

    static boolean test3(int val) {
        System.out.println("test3");
        return val < 3;
    }

    public static void main(String[] args) {
        boolean test = test1(0) && test2(2) && test3(2);
    }
}
