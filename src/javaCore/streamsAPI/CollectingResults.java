package javaCore.streamsAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Накопление результатов,
 *
 * @author Ross Khapilov
 * @version 1.0 26.09.2018
 */
public class CollectingResults {
    public static Stream<String> noVowels() {
        String contents = "The quick brown fox jumps over the lazy dog";
        //разделить строку на отдельные слова.
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        //получаем поток данных
        Stream<String> words = wordList.stream();
        //убираем все гласные
        return words.map(s -> s.replaceAll("[aeiouAEIOU]", ""));
    }

    public static <T> void show(String label, Set<T> set) {
        System.out.print(label + ": " + set.getClass().getName());
        System.out.println("{"
                + set.stream()
                //только для первых 10 элементов
                .limit(10)
                //для каждого элемента вызываем метод toString() и преобразуем их в строки
                .map(Object::toString)
                //сцепляем элементы и указываем разделитель элементов
                .collect(Collectors.joining(", "))
                + "}");
    }

    public static void main(String[] args) {
        //получаем итератор из потока данных арифметической прогрессии для первых 10 элементов
        Iterator<Integer> iter = Stream.iterate(0, n -> n + 1).limit(10).iterator();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println();

        //Получаем массив Object[] из потока данных
        Object[] numbers = Stream.iterate(0, n -> n + 1).limit(10).toArray();
        System.out.println("Object array: " + numbers);

        try {
            Integer number = (Integer) numbers[0];
            System.out.println("number[0]: " + number);
            System.out.println("Тут получим исключение:");
            Integer[] numbers2 = (Integer[]) numbers;
        } catch (ClassCastException ex) {
            System.out.println(ex);
        }

        //В методе toArray[] можно указать тип массива и тогда мы получим нужным нам тип, а не Object[]
        Integer[] numbers3 = Stream.iterate(0, n -> n + 1).limit(10).toArray(Integer[]::new);
        System.out.println("Integer array: " + numbers3);

        Set<String> noVowelsSet = noVowels()
                //Преобразуем поток данных в коллекцию Типа Set
                .collect(Collectors.toSet());
        show("noVowelsSet", noVowelsSet);

        TreeSet<String> noVowelsTreeSet = noVowels()
                //преобразуем поток данных в нужный нам тип коллекции
                .collect(Collectors.toCollection(TreeSet::new));
        show("noVowelsTreeSet", noVowelsTreeSet);

        String result = noVowels().limit(5).collect(Collectors.joining());
        System.out.println("Joining: " + result);

        //Если результаты обработки потока данных требуется свести к сумме, среднему, максимуму или минимуму,
        // воспользуйтесь методами типа summarizing (Int | Long I Double). Эти методы принимают функцию,
        // преобразующую потоковые объекты в число и возвращающую результат типа
        // (Int | Long | Double) SummaryStatistics, одновременно вычисляя сумму, среднее, максимум и минимум,.
        IntSummaryStatistics summary = noVowels().collect(Collectors.summarizingInt(String::length));
        double averageWordLength = summary.getAverage();
        double maxWordLength = summary.getMax();
        System.out.println("Average word length: " + averageWordLength);
        System.out.println("Max word length: " + maxWordLength);
        System.out.println("forEach:");
        noVowels().limit(6).forEach(System.out::println);
    }
}