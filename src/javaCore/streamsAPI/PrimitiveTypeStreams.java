package javaCore.streamsAPI;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Для эффективной работы с потоками данных примитивных типов лучше всего
 * пользоваться классами: IntStream, DoubleStream, LongStream,
 * а не Stream<Integer> т.к. не придется тратить лишние ресурсы на оболочки
 * <p>
 * Создавать такие потоки данных удобно через IntStream.of() и Arrays.stream()
 * <p>
 * Как правило, методы для потоков данных примитивных типов аналогичны методам для потоков объектов.
 * Ниже перечислены наиболее существенные их отличия.
 * <p>
 * • Методы типа toArray возвращают массивы примитивных типов.
 * <p>
 * • Методы, возвращающие результат необязательного типа, возвращают значение типа OptionalInt, OptionalLong
 * или OptionalDouble. Классы этих типов аналогичны классу Optional, но у них имеются методы getAsInt(),
 * getAsLong() и getAsDouble() вместо метода get().
 * <p>
 * • Имеются методы sum(), average(), max() и min(), возвращающие сумму, среднее, максимум и минимум соответственно.
 * Эти методы не определены для потоков объектов.
 * <p>
 * • Метод summaryStatistics() возвращает объект типа IntSummary- Statistics, LongSummaryStatistics
 * или DoubleSummaryStatistics, способный одновременно сообщать о сумме, среднем, максимуме и минимуме в потоке данных.
 *
 * @author Ross Khapilov
 * @version 1.0 27.09.2018
 */
public class PrimitiveTypeStreams {

    public static void show(String title, IntStream stream) {
        final int SIZE = 10;
        int[] firstElements = stream.limit(SIZE + 1).toArray();
        System.out.print(title + ": ");
        for (int i = 0; i < firstElements.length; i++) {
            if (i > 0) System.out.print(", ");
            if (i < SIZE) System.out.print(firstElements[i]);
            else System.out.print("...");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        //такие потоки можно преобразовать в примитивные и обратно
        Stream<String> words = Stream.of("Tom", "Jerry", "Terry", "Bob");
        IntStream lengths = words.mapToInt(String::length);
        Stream<Integer> integers = IntStream.range(0, 100).boxed();
        IntStream is0 = integers.mapToInt(Integer::intValue);
        show("is0", is0);

        IntStream is1 = IntStream.generate(() -> (int) (Math.random() * 100));
        show("is1", is1);
        IntStream is2 = IntStream.range(5, 10);
        show("is2", is2);
        IntStream is3 = IntStream.rangeClosed(5, 10);
        show("is3", is3);

        String sentence = "\uD835\uDD46 is the set of octonions.";
        System.out.println(sentence);
        IntStream codes = sentence.codePoints();
        System.out.println(codes.mapToObj(c -> String.format("%X ", c)).collect(Collectors.joining()));
    }
}
