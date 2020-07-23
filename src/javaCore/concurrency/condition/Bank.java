package javaCore.concurrency.condition;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * По условию в потоке исполнения может быть вызван только метод await(),
 * signalAll() или signal(), когда этот поток владеет блокировкой по данному условию.
 *
 * @author Ross Khapilov
 * @version 1.0 10.09.2018
 */
public class Bank {
    private final double[] accounts;
    private final Lock lock = new ReentrantLock();
    private final Condition condition;

    /**
     * Создает банк с клиентами и одинаковыми счетами
     *
     * @param numOfClients количество клиентов
     * @param balance      баланс на счетах
     */
    public Bank(int numOfClients, double balance) {
        accounts = new double[numOfClients];
        Arrays.fill(accounts, balance);
        condition = lock.newCondition();
    }

    /**
     * Перевод средства между счетами
     *
     * @param from   клиент с которого будем списывать деньги
     * @param to     кому они будут поступать
     * @param amount количество денег
     */
    public void transfer(int from, int to, double amount) throws InterruptedException {
        lock.lock();
        try {
            //если денег на счете недостаточно, данный поток блокируется пока не будет вызван метод signalAll().
            while(accounts[from]< amount)
                condition.await();
            accounts[from] -= amount;
            accounts[to] += amount;
            System.out.print(Thread.currentThread());
            System.out.printf(" %10.2f from %d to %d Total Balance: %10.2f%n", amount, from, to, getTotalBalance());
            condition.signalAll();
        } finally {
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
