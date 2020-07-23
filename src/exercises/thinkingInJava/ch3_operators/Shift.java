package thinkingInJava.ch3_operators;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 29.12.2017
 */
public class Shift {
    public static void main(String[] args) {
        int numA = 0b1010;
        int numB = 0b1101;
        System.out.println("numA " + numA + "; numB " + numB);
        System.out.println("| " + (numA | numB));
        System.out.println("& " + (numA & numB));
        System.out.println("^ " + (numA ^ numB));
        System.out.println("~A " + (~numA));
    }
}
