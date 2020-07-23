package javaCore.streamsAPI;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Для эффективного применения типа Optional самое главное — выбрать метод, который возвращает
 * альтернативный вариант, если значение отсутствует, или употребляет значение, если только оно присутствует.
 *
 * @author Ross Khapilov
 * @version 1.0 25.09.2018
 */
public class OptionalTest {
    /**
     * Как стоит обращаться с классом Optional
     */
    private static void goodPractice() {
        Stream<String> word = Stream.of("Tom", "Paul", "Jerry", "Mitch").filter(s -> s.startsWith("E"));
        Optional<String> optionalString = word.findAny();

        //если нет подходящий значений то вернет вариант указанный в методе orElse()
        System.out.println(optionalString.orElse("нет подходящий значений"));
        //почти тоже самое
        System.out.println(optionalString.orElseGet(() -> System.getProperty("user.dir")));
        //или же можно сгенерировать исключение
        try {
            System.out.println(optionalString.orElseThrow(IllegalStateException::new));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        //ifPresent() если необязательное значение существует, оно передается данной функции.
        // В противном случае ничего не происходит.
        ArrayList<String> strings = new ArrayList<>();
        optionalString.ifPresent(strings::add);
        System.out.println(strings);
    }

    /**
     * Если же требуется написать метод, создающий объект типа Optional,
     * то для этой цели имеется несколько статических методов.
     * В приведенном ниже примере демонстрируется применение
     * двух таких методов: Optional. of(result) и Optional.empty().
     */
    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }

    public static void main(String[] args) {
        goodPractice();
    }
}
