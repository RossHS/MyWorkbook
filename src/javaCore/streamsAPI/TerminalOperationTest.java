package javaCore.streamsAPI;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * terminal operation - методы сведения. Они выполняют оконечные операции, сводя поток данных к непотоковому значению,
 * которое может быть далее использовано в программе.
 *
 * @author Ross Khapilov
 * @version 1.0 25.09.2018
 */
public class TerminalOperationTest {
    public static void main(String[] args) {
        //самый просто пример метода сведения
        System.out.println("sum " + IntStream.of(1, 2, 3, 4).filter(x -> x > 2).sum());

        //пример max()
        System.out.println(Stream.of(1, 2, 4).max(Integer::compareTo).get());
        Optional<String> largest = Stream.of("AVC", "AB").max(String::compareToIgnoreCase);
        System.out.println("max " + largest.get());

        //Метод findFirst () возвращает первое значение из непустой коллекции.
        //Зачастую он применяется вместе с методом filter().
        // Если же требуется любое совпадение, а не только первое, то следует воспользоваться методом findAny()
        Optional<String> startWithQ = Stream.of("QVC", "Qbc", "asd").filter(s -> s.startsWith("Q")).findFirst();
        System.out.println("find " + startWithQ.get());

        //anyMatch() для проверки, имеются ли вообще совпадения. похожим образом работают nonMatch() allMatch()
        boolean lessThen3 = IntStream.of(1, 2, 4, 0).anyMatch(value -> value < 3);
        System.out.println("anyMatch " + lessThen3);
    }
}
