package javaCore.concurrency;

/**
 * ThreadLocal — это тип, значение которого своё в каждом потоке.
 * <p>
 * Для чего такое может понадобиться? Если несколько сценариев.
 * <p>
 * Например, у вас есть приложение, которое пользуется различными библиотеками и фреймворками, цепочка вызовов уходит
 * очень глубоко, и где-то там вызывает ваш callback. Вы хотели бы передать дополнительную информацию (например, права
 * текущего юзера, или там просто кэш), но промежуточные фреймворки не протягивают через цепочку вызовов эту
 * дополнительную информацию. Что делать? Можно воспользоваться статическими переменными, но что если ваше приложение
 * многопоточное? За статические переменные будет конкуренция между потоками. Решение — кладите информацию на входе в
 * ThreadLocal, на выходе в callback'е можно будет забрать.
 * <p>
 * Другой сценарий — это тот же кэш. В условиях многопоточной программы держать кэш потокобезопасным может оказаться
 * дорого, ведь при этом каждое обращение к кэшу означает дорогую синхронизацию. Решение — завести по экземпляру кэша
 * в каждом потоке, положив его в ThreadLocal.
 * <p>
 * Похожий сценарий описан здесь: многопоточный доступ к SimpleDateFormat не разрешён, и чтобы не пересоздавать объект
 * при каждом вызове, можно закэшировать его в ThreadLocal
 *
 * @author Ross Khapilov
 * @version 1.0 12.09.2018
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> num;
    private static int staticNum;
    private int number;

    ThreadLocalTest(int var, int statNum, int number) {
        num = ThreadLocal.withInitial(() -> var);
        staticNum = statNum;
        this.number = number;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {

                ThreadLocalTest threadLocalTest1 = new ThreadLocalTest(finalI - 10, finalI - 10, finalI - 10);
                ThreadLocalTest threadLocalTest2 = new ThreadLocalTest(finalI + 10, finalI + 10, finalI + 10);
                num.set(finalI - 30);
                while (true) {
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread() + " ThreadLocal num = " + num.get() +
                                " static num = " + staticNum + " number1 = " + threadLocalTest1.number +
                                " number2 = " + threadLocalTest2.number);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }).start();
        }
    }


}
