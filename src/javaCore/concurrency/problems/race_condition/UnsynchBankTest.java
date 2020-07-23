package javaCore.concurrency.problems.race_condition;

/**
 * Будет возникать состояние гонки, т.к так как ресурсами одного объектом будут пользоваться несколько потоков,
 * что будет приводить к неправильной работе программы, тут же корень проблемы в методе transfer(),
 * будь он синхронизирован таких бы проблем не было.
 * <p>
 * Байт-коды, выполняемые виртуальной машиной в классе Bank, можно просмотреть.
 * Для этого достаточно ввести следующую команду декомпиляции файла Bank.class:
 * javap -с -v Bank
 * Например, следующая строка кода:
 * accounts[to] += amount;
 * транслируется в приведенный ниже байт-код.
 * aload_0
 * getfield #2; // поле accounts: [D
 * iload_2
 * dup2
 * daload
 * dload 3
 * dadd
 * dastore
 * Неважно, что именно означают эти байт-коды. Важнее другое: операция инкрементирования состоит
 * из нескольких команд, и исполняющий их поток может быть прерван на любой из них.
 *
 * @author Ross Khapilov
 * @version 1.0 05.09.2018
 */
public class UnsynchBankTest {
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
