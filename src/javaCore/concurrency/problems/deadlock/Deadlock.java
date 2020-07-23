package javaCore.concurrency.problems.deadlock;

import java.util.Arrays;

/**
 * Возникает, когда поток заблокирован, и ждет пока другой поток его разблокирует, но вместо того,
 * чтобы разблокировать первый поток второй блокируется сам, и возникает состояние взаимной блокировки.
 * <p>
 * К сожалению, в Java отсутствуют средства, исключающие или снимающие взаимные
 * блокировки. Поэтому вам придется разрабатывать свои программы таким образом,
 * чтобы полностью исключить ситуации, приводящие к взаимным блокировкам.
 *
 * @author Ross Khapilov
 * @version 1.0 11.09.2018
 */
public class Deadlock {
    private final double[] clients;
    private final int money;

    private Deadlock(int numOfClient, int money) {
        clients = new double[numOfClient];
        this.money = money;
        Arrays.fill(clients, money);
    }

    public static void main(String[] args) {
        Deadlock d = new Deadlock(5, 200);
        for (int i = 0; i < d.clients.length; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    while (true) {
                        int to = (int) (d.clients.length * Math.random());
                        double amount = 5*d.money * Math.random();
                        Thread.sleep((long) (10 * Math.random()));
                        d.transfer(finalI, to, amount);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        if(clients[from] < amount) wait(); // произойдет дедлок, так как возможна такая ситуация при которой все потоки будут заблокированы
        clients[from] -= amount;
        clients[to] += amount;
        double total = Arrays.stream(clients).sum();
        System.out.println(Thread.currentThread() + " from " + from + " to " + to + " " + amount + " total " + total);
       notify();
    }

}
