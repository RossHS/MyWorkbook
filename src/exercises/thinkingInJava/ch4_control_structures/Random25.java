package thinkingInJava.ch4_control_structures;

import java.util.Random;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 30.12.2017
 */
public class Random25 {
    public static void main(String[] args) {
        Random random = new Random();
        int temp = random.nextInt(11);
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(11);
            if (temp > num) System.out.println(temp + " > " + num);
            else if (temp < num) System.out.println(temp + " < " + num);
            else System.out.println(temp + " = " + num);
            temp = num;
        }
    }
}
