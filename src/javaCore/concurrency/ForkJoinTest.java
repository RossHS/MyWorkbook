package javaCore.concurrency;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.DoublePredicate;

/**
 * Вилочное соединение- разделение задачи на несколько потоков и объединение их результатов работы в конце,
 * пригождается для ускорения выполнения сложных задач.
 * <p>
 * В этой программе показывается пример вилочной архитектуры
 *
 * @author Ross Khapilov
 * @version 1.0 17.09.2018
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        final int SIZE = 10_000_000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++)
            numbers[i] = Math.random();
        Counter counter = new Counter(numbers, 0, numbers.length, x -> x > 0.5);

        //Создаем вилочный пул потоков
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());
    }
}

class Counter extends RecursiveTask<Integer> {
    public static final int THRESHOLD = 1000;
    private double[] values;
    private int from;
    private int to;
    private DoublePredicate filter;

    public Counter(double[] values, int from, int to, DoublePredicate filter) {
        this.values = values;
        this.from = from;
        this.to = to;
        this.filter = filter;
    }

    @Override
    protected Integer compute() {
        if (to - from < THRESHOLD) {
            int count = 0;
            for (int i = from; i < to; i++) {
                if (filter.test(values[i])) count++;
            }
            return count;
        } else {
            int mid = (from + to) / 2;
            Counter first = new Counter(values, from, mid, filter);
            Counter second = new Counter(values, mid, to, filter);

            /*
            В данном примере метод invokeAll () получает ряд задач и блоков до тех пор,
            пока их выполнение не будет завершено, а метод join () объединяет полученные результаты.
            В частности, метод join () вызывается для каждой подзадачи, а в итоге возвращается
            сумма результатов их выполнения.
             */
            invokeAll(first, second);
            return first.join() + second.join();
        }
    }
}
