package thinkingInJava.ch4_control_structures;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 30.12.2017
 */
public class RandomWhile implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        RandomWhile randomWhile = new RandomWhile();
        Thread thread = new Thread(randomWhile);
        thread.start();
        int temp = random.nextInt(11);
        while (true) {
            int num = random.nextInt(11);
            if (temp > num) System.out.println(temp + " > " + num);
            else if (temp < num) System.out.println(temp + " < " + num);
            else System.out.println(temp + " = " + num);
            temp = num;
            Thread.sleep(300);
        }
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()) System.exit(0);
    }
}
