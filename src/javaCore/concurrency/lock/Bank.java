package javaCore.concurrency.lock;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Банк с счетами
 *
 * @author Ross Khapilov
 * @version 1.0 05.09.2018
 */
public class Bank {
    private final double[] accounts;
    private final Lock lock = new ReentrantLock();

    /**
     * Создает банк с клиентами и одинаковыми счетами
     *
     * @param numOfClients количество клиентов
     * @param balance      баланс на счетах
     */
    public Bank(int numOfClients, double balance) {
        accounts = new double[numOfClients];
        Arrays.fill(accounts, balance);
    }

    /**
     * Перевод средства между счетами
     *
     * @param from   клиент с которого будем списывать деньги
     * @param to     кому они будут поступать
     * @param amount количество денег
     */
    public void transfer(int from, int to, double amount) {
        lock.lock();
        try {
            accounts[from] -= amount;
            accounts[to] += amount;
            System.out.print(Thread.currentThread());
            System.out.printf(" %10.2f from %d to %d Total Balance: %f%n", amount, from, to, getTotalBalance());
        } finally {
            /**
             * Крайне важно разместить вызов метода unlock() в блоке finally . Если код в критическом
             * разделе сгенерирует исключение, блокировка должна быть непременно снята. В противном
             * случае другие потоки исполнения будут заблокированы навсегда.
             */
            lock.unlock();
        }
    }

    /**
     * Расчет общего баланса
     *
     * @return Общий баланс
     */
    private double getTotalBalance() {
        return Arrays.stream(accounts).sum();
    }

    /**
     * Рассчитает количество клиентов банка
     *
     * @return размер банка.
     */
    public int size() {
        return accounts.length;
    }
}
