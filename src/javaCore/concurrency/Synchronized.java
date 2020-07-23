package javaCore.concurrency;

/**
 * Интерфейсы Lock и Condition предоставляют программистам высокую степень
 * контроля над блокировками. Но зачастую такой контроль не требуется, и оказывается
 * достаточно механизма, встроенного в язык Java. Еще со времен версии 1.0 каждый
 * объект в Java обладает встроенной блокировкой. Если метод объявлен с ключевым
 * словом synchronized, то блокировка объекта защищает весь этот метод. Следовательно,
 * поток исполнения должен захватить встроенную блокировку объекта.
 * Например, вместо явной блокировки можно просто объявить метод transfer ()
 * из класса Bank как synchronized. Встроенная блокировка объектов имеет единственное
 * связанное с ней условие. Метод wait () вводит поток исполнения в набор ожидания,
 * а методы notifyAll()/notify () разблокируют ожидающие потоки. Иными
 * словами, вызов метода wait () или notifyAll () равнозначен следующему коду:
 * встроенноеУсловие.await() ;
 * встроенноеУсловие. signalAll() ;
 * <p>
 * Статические методы также допускается объявлять синхронизированными. Когда
 * вызывается такой метод, он захватывает встроенную блокировку объекта соответствующего
 * класса. Так, если в классе Bank имеется статический синхронизированный метод,
 * при его вызове захватывается блокировка объекта типа Bank, class. В результате
 * к этому объекту не может обратиться никакой другой поток исполнения и никакой
 * другой синхронизированный статический метод того же класса.
 * Встроенным блокировкам и условиям присущи некоторые ограничения, в том
 * числе приведенные ниже.
 * • Нельзя прервать поток исполнения, который пытается захватить блокировку.
 * • Нельзя указать время ожидания, пытаясь захватить блокировку.
 * • Наличие единственного условия на блокировку может оказаться неэффективным.
 * Что же лучше использовать в прикладном коде: объекты типа Lock и Condition
 * или синхронизированные методы? Ниже приведены некоторые рекомендации, которые
 * дают ответ на этот вопрос.
 * • Лучше не пользоваться ни объектами типа Lock/Condition, ни ключевым
 * словом synchronized. Зачастую вместо этого можно выбрать подходящий
 * механизм из пакета java.util.concurrent, который организует блокировку
 * автоматически. Так, в разделе 14.6 далее в этой главе будет показано, как пользоваться
 * блокирующими очередями для синхронизации потоков, выполняющих
 * общую задачу.
 * • Если ключевое слово synchronized подходит в конкретной ситуации, непременно
 * воспользуйтесь им. В этом случае вам придется написать меньше кода,
 * а следовательно, допустить меньше ошибок. В листинге 14.8 приведен пример
 * очередного варианта программы, имитирующей банк и реализованной на основе
 * синхронизированных методов.
 * • Пользуйтесь объектами типа Lock/Condition, если действительно нуждаетесь
 * в дополнительных возможностях подобных конструкций.
 * вызвать такой метод.
 *
 * @author Ross Khapilov
 * @version 1.0 10.09.2018
 */
public class Synchronized {
    int a = 10;
    int b = 10;
    int c = a + b;

    public static void main(String[] args) {
        Synchronized s = new Synchronized();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep((long) (Math.random() * 100));
                        s.count3((int) (Math.random() * 10));
                        System.out.println(Thread.currentThread() + "  c=" + s.c);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    /**
     * Небезопасно, тк изменяем ресурсы из разных поток
     *
     * @param n
     */
    private void count(int n) {
        a -= n;
        b += n;
        c = a + b;
    }

    /**
     * Безопасно, тк при вызове этого метода остальные потоки блокируется.
     *
     * @param n
     */
    private synchronized void count2(int n) {
        a -= n;
        b += n;
        c = a + b;
    }

    /**
     * Тоже самое, что и второй вариант
     *
     * @param n
     */
    private void count3(int n) {
        synchronized (this) {
            a -= n;
            b += n;
            c = a + b;
        }
    }


}
