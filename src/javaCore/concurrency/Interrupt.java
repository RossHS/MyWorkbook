package javaCore.concurrency;

/**
 * void interrupt() - Посылает потоку исполнения запрос на прерывание. Признак состояния прерывания потока исполнения
 * устанавливается равным логическому значению true. Если поток в данный момент блокирован вызовом метода sleep(),
 * генерируется исключение типа InterruptedException.
 * <p>
 * static boolean interrupted() - Проверяет, был ли прерван текущий поток исполнения. Следует, однако, иметь в виду,
 * что это статический метод. Его вызов имеет побочный эффект: признак состояния прерывания текущего потока исполнения
 * устанавливается равным логическому значению false.
 * <p>
 * boolean islnterrupted() - Проверяет, был ли прерван поток исполнения. В отличие от статического метода interrupted(),
 * вызов этого метода не изменяет состояние прерывания потока исполнения.
 * <p>
 * static Thread currentThread() - Возвращает объект типа Thread, представляющий текущий поток исполнения.
 *
 * @author Ross Khapilov
 * @version 1.0 03.09.2018
 */
public class Interrupt {
    /**
     * Пример обработки InterruptedException, Когда метод interrupt() вызывается для потока исполнения, который
     * заблокирован, например, в результате вызова метода sleep() или wait(), блокирующий вызов прерывается исключением
     * типа InterruptedException.
     * Варианты обработки
     * 1) Добавить в сигнатуру метода throws InterruptedException
     * 2) Сделать в блоке catch вызов Thread.CurrentThread.interrupt(), чтобы установить состояние прерывания потока
     * исполнения, как выделено ниже полужирным. И тогда это состояние может быть проверено в вызывающей части программы.
     */
    private static void interruptedExceptionExample() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static class InterruptEx implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Сон начался");
                sleep2sec();
                System.out.println("Сон закончился\n");
            }
            System.out.println(Thread.currentThread().getName() + " завершил работу");
        }

        private void sleep2sec() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Сон прерван");
                Thread.currentThread().interrupt(); //без этой строчки, код будет выполняться бесконечно!!!
                //т.к. генерация исключения сбрасывает флаг, поэтому более высокоуровневые методы могут никогда не узнать
                //о том, что поток был прерван, а следовательно и корректно завершить работу.
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new InterruptEx());
        t.start();
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + " 5000 прошло");

        //Вызов метода потока interrupt просто устанавливает флаг, означающий,
        //что код, использующий этот поток, хочет его прервать.
        t.interrupt();

        t.join();
        System.out.println(Thread.currentThread().getName() + " завершил работу");
    }
}
