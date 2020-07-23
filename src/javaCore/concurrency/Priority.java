package javaCore.concurrency;

/**
 * В языке программирования Java каждый поток исполнения имеет свой приоритет. По умолчанию поток исполнения
 * наследует приоритет того потока, который его создал. Повысить или понизить приоритет любого потока исполнения можно,
 * вызвав метод setPriorityO. А установить приоритет потока исполнения можно, указав любое значение в пределах от
 * MIN PRIORITY (определено в классе Thread равным 1) до MAX PRIORITY (равно 10). Обычному приоритету соответствует
 * значение NORM_PRIORITY, равное 5. Начинающие программисты иногда злоупотребляют приоритетами потоков исполнения.
 * Но имеется не так уж и много причин для того, чтобы манипулировать приоритетами. Поэтому не рекомендуется писать
 * свои программы таким образом, чтобы их правильное функционирование зависело от уровней приоритетов.
 *
 * @author Ross Khapilov
 * @version 1.0 03.09.2018
 */
public class Priority implements Runnable {
    private int count;
    private Thread thread;
    private static boolean stop = false;

    Priority(String name) {
        thread = new Thread(this, name);
        count = 0;
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " - запущен");
        do {
            count++;
        } while (stop == false && count < 1_000_000);
        stop = true;
        System.out.println("\n" + thread.getName() + " - завершен");
    }

    public static void main(String[] args) {
        Priority priority1 = new Priority("high Priority");
        Priority priority2 = new Priority("low Priority");

        priority1.thread.setPriority(7);
        priority2.thread.setPriority(6);

        priority1.thread.start();
        priority2.thread.start();

        try {
            priority1.thread.join();
            priority2.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Поток прерван");
        }
        System.out.println("\nСчетчик потока " + priority1.thread.getName() + " " + priority1.count);
        System.out.println("\nСчетчик потока " + priority2.thread.getName() + " " + priority2.count);
    }
}
