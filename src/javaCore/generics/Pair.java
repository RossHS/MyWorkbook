package javaCore.generics;

/**
 * Пример создания собственного обобщенного класса
 *
 * @author Ross Khapilov
 * @version 1.0 created on 25.03.2018
 */
public class Pair<T> {
    private T min;
    private T max;

    public Pair() {
        min = null;
        max = null;
    }

    public Pair(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public void setMin(T min) {
        this.min = min;
    }

    public void setMax(T max) {
        this.max = max;
    }

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }

    /**
     * Метод для поиска минимального и максимального элемента в массиве
     *
     * @param array - массив, в котором ищется минимальное и максимальное значение
     * @param <S>   - любой тип реализующий интерфейс Comparable
     * @return Объект содержащий минимальное и максимальное значение массива array. Если он имеет нулевую длину, то null
     */
    public static <S extends Comparable<S>> Pair<S> minmax(S[] array) {
        if (array == null || array.length == 0) return null;
        S min = array[0];
        S max = array[0];
        for (S a : array) {
            if (min.compareTo(a) > 0) min = a;
            if (max.compareTo(a) < 0) max = a;
        }
        return new Pair<>(min, max);
    }

    public static void main(String[] args) {
        Integer[] a = {1, -2, 3, 4, -5};
        Pair<Integer> integerPair = minmax(a);
        System.out.println("Min = " + integerPair.getMin() + "; Max = " + integerPair.getMax());
    }
}