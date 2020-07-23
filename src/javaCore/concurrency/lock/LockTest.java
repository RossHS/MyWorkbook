package javaCore.concurrency.lock;


/**
 * @author Ross Khapilov
 * @version 1.0 08.09.2018
 */
public class LockTest {
    private static final int CLIENTS = 100;
    private static final double AMOUNT_OF_MONEY = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(CLIENTS, AMOUNT_OF_MONEY);
        for (int i = 0; i < CLIENTS; i++) {
            int from = i;
            new Thread(() -> {
                while (true) {
                    try {
                        int to = (int) (bank.size() * Math.random());
                        double amount = AMOUNT_OF_MONEY * Math.random();
                        Thread.sleep((long) (100 * Math.random()));
                        bank.transfer(from, to, amount);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
