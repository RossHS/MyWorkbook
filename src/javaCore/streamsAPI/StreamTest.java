package javaCore.streamsAPI;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * На первый взгляд поток данных похож на коллекцию, поскольку он позволяет преобразовывать и извлекать данные.
 * Но у потока данных имеются следующие существенные отличия.
 * <p>
 * 1. Поток данных не сохраняет свои элементы. Они могут храниться в основной коллекции или формироваться по требованию.
 * <p>
 * 2. Потоковые операции не изменяют их источник. Например, метод filter () не удаляет элементы из нового потока данных,
 * но выдает новый поток, в котором они отсутствуют.
 * <p>
 * 3. Потоковые операции выполняются по требованию, когда это возможно. Это означает, что они не выполняются до тех пор,
 * пока не потребуется их результат. Так, если требуется подсчитать только пять длинных слов вместо всех слов,
 * метод filter () прекратит фильтрацию после пятого совпадения. Следовательно, потоки данных могут быть бесконечными!
 * <p>
 * Конвейер операций организуется в следующие три стадии.
 * 1. Создание потока данных.
 * <p>
 * 2. Указание промежуточных операций для преобразования исходного потока данных в другие потоки — возможно,
 * в несколько этапов.
 * <p>
 * 3. Выполнение оконечной операции для получения результата. Эта операция принуждает к выполнению по требованию
 * тех операций, которые ей предшествуют. А впоследствии поток данных может больше не понадобиться.
 *
 * @author Ross Khapilov
 * @version 1.0 25.09.2018
 */
public class StreamTest {

    /**
     * В результате преобразования потока данных получается другой поток данных,
     * элементы которого являются производными от элементов исходного потока.
     */
    private static void filterMapFlatMap() {
        //метод filter() нужен для создания нового потока удовлетворяющего условиями фильтрации Predicate<T>
        Stream<String> filter = Stream.of("ABC", "A", "ADF", "D").filter(x -> x.length() < 2);
        System.out.println("filter " + Arrays.toString(filter.toArray()));

        //Метод map() нужен для преобразования элементов в потоке данных.
        Stream<String> map = Stream.of("ACsca", "sdasd", "roW2e").map(String::toUpperCase);
        System.out.println(Arrays.toString(map.toArray()));

        //Возвращает поток данных, получаемый сцеплением результатов применения функции mapper() к элементам исходного
        // потока данных. (Следует иметь в виду, что каждый результат представляет собой отдельный поток данных.)
    }

    public static void main(String[] args) {
        int[] ints = {1, 23, 13, 10, 4, 0};
        //при помощи StreamAPI подсчитаем сумму всех элементов массива больше или равным 10
        long sum = Arrays.stream(ints)
                .filter(x -> x >= 10)
                .sum();
        System.out.println(sum);

        //число элементов, длина которых больше 2
        List<String> strings = Arrays.asList("A", "B", "ABC", "AB");
        long count = strings.parallelStream()
                .filter(w -> w.length() > 2)
                .count();
        System.out.println(count);

        //Можно создать поток данных бех элементов
        // Обобщенный тип <String> выводится автоматически;
        // что равнозначно вызову Stream.<String>empty()
        Stream<String> silence = Stream.empty();

        //Можно создать бесконечный поток данных
        Stream<Integer> randoms = Stream.generate(() -> (int) (Math.random() * 10));
        System.out.println(Arrays.toString(randoms.limit(5).toArray()));

        //Можно создать бесконечную последовательность вроде 0 1 2 3 ...
        Stream<BigInteger> infinity = Stream
                .iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE))
                .limit(3);
        System.out.println(Arrays.toString(infinity.toArray()));

        Stream<BigInteger> infinity2 = Stream
                .iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE))
                .skip(6)
                .limit(2);
        System.out.println(Arrays.toString(infinity2.toArray()));

        //Потоки данных можно объединить при помощи метода concat()


        //distinct() возвращает поток данных, получающий свои элементы из исходного потока данных в том же самом
        // порядке, за исключением того, что дубликаты в нем подавляются.
        Stream<String> uniqueWords = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
        System.out.println(Arrays.toString(uniqueWords.toArray()));

        //Для сортировки потоков данных имеется несколько вариантов метода sorted ().
        // Один из них служит для обработки потоков данных, состоящих из элементов типа Comparable,
        // а другой принимает в качестве параметра компаратор типа Comparator.
        Stream<String> longestFirst = Stream.of("123", "1", "1234", "12")
                .sorted(Comparator.comparingInt(String::length).reversed());
        System.out.println(Arrays.toString(longestFirst.toArray()));

        //метод реек () выдает другой поток данных с теми же самыми элементами, что и у исходного потока,
        // но передаваемая ему функция вызывается всякий раз, когда извлекается элемент. удобно для отладки.
        Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.println("peek " + e))
                .limit(3).toArray();

        /*
        В прикладном программном интерфейсе Java API имеется целый ряд методов, возвращающих потоки данных.
         Так, в классе Pattern имеется метод splitAsStreamO, разделяющий последовательность символов
         типа CharSequence по регулярному выражению. Например, для разделения символьной строки на отдельные
         слова можно воспользоваться следующим оператором:
        Stream<String> words = Pattern.compile("\\PL+"). splitAsStream(contents);

        А статический метод Files. lines () возвращает поток данных типа Stream, содержащий все строки из файла,
        как показано ниже.
        try (Stream<String> lines = Files.lines(path)) {
            Обработать строки
        }
         */

        filterMapFlatMap();
    }
}
