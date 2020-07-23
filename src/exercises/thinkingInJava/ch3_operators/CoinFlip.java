package thinkingInJava.ch3_operators;

import java.util.Random;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 19.12.2017
 */
public class CoinFlip {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            boolean coin = random.nextBoolean();
            if(coin) System.out.println("Орел");
            else System.out.println("Решка");
        }
    }
}
