package thinkingInJava.ch4_control_structures;

import java.util.Scanner;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 05.01.2018
 */
public class Fibonacci {
    public static void main(String[] args) {
        int count = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextInt()) count = scanner.nextInt();
        }
        int num1 = 1;
        int num2 = 1;
        System.out.print(num1 + " " + num2 + " ");
        for (int i = 2; i < count; i++) {
            int sum = num1 + num2;
            System.out.print(sum + " ");
            num1 = num2;
            num2 = sum;
        }
    }
}
