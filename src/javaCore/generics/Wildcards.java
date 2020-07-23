package javaCore.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Подстановочный тип. Важным ограничением является то, что допусти мы указываем обобщенный класс Pair<?> то не сможем
 * воспользоваться сеттерами. Так как ? не приводится к Object, а просто является "ограничением"
 *
 * @author Ross Khapilov
 * @version 1.0 created on 12.04.2018
 */
public class Wildcards {
    //Мы можем создать обобщенный класс, с конструкцией <T extends Number> что будет тем же самым, то использование
    //метасимвола ?. т.е. ? значит, что подходит любой дженерик тип
    private static void print(List<? extends Number> p) {
        for (Number n : p) {
            System.out.print("{" + n + "} ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("A", "acb", "E"));
        integers.toString();
        print(integers);

        //? подходит любой дженерик тип. Все скомпилируется.
        ArrayList<?> arrayList = new ArrayList<Integer>(Arrays.asList(1, 2));
        arrayList = new ArrayList<String>(Arrays.asList("a", "v"));

        //Теперь повторим, но с ограничением
        ArrayList<? extends Number> arrayList1 = new ArrayList<Integer>(Arrays.asList(1, 2));
        //Вторая строчка не скомпилируется, т.к. String не наследуется от Number
        //arrayList1 = new ArrayList<String>(Arrays.asList("a","v"));
        arrayList1 = new ArrayList<Double>(Arrays.asList(1.2, 2.3, 2.1313));

        //ограничение снизу. Если рассуждать интуитивно, то подстановки с ограничениями супертипа позволяют
        //записывать данные в обобщенный объект, а подстановки с ограничениями подтипа
        //— читать данные из обобщенного объекта. Рассмотрим другой пример наложения
        //ограничений супертипа.
        ArrayList<? super ArrayList> objects = new ArrayList<List>();
    }
}
