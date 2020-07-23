package javaCore.lambda_method_references;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Главным улучшением в Java 8 является добавление поддержки функциональных программных конструкций к его
 * объектно-ориентированной основе. В этой статье я продемонстрирую основной синтаксис и как использовать его в
 * нескольких важных контекстах. Ключевые моменты понятия лямбды:
 * <p>
 * Лямбда-выражение является блоком кода с параметрами.
 * Используйте лямбда-выражение, когда хотите выполнить блок кода в более поздний момент времени.
 * Лямбда-выражения могут быть преобразованы в функциональные интерфейсы.
 * Лямбда-выражения имеют доступ к final переменным из охватывающей области видимости.
 * Ссылки на метод и конструктор ссылаются на методы или конструкторы без их вызова.
 * Теперь вы можете добавить методы по умолчанию и статические методы к интерфейсам, которые обеспечивают конкретные
 * реализации.
 * Вы должны разрешать любые конфликты между методами по умолчанию из нескольких интерфейсов.
 * <p>
 * Лямбда выражения полностью зависит от от функциональных интерфейсов, т.е. от таких интерфейсов, где есть лишь один
 * абстрактный метод.
 * <p>
 * Все новые функциональные интерфейсы находятся в пакете java.util.functional и они отмечены новой
 * аннотацией @FunctionalInterface
 *
 * @author Ross Khapilov
 * @version 1.0 created on 08.01.2018
 */
public class LambdaMain {
    public static void main(String[] args) {
        sort(); //Пример 1 сортировкой различными способами
        int a = 10;
        int b = 10;
        int c = 10;

        int d = a + b == c ? 10 : c;
        if (a + b == c) {
            d = c;
        } else {
            d = 10;
        }
        //Пример 2 различная реализация собственного функционального интерфейса
        NumericTest isEven = num -> (num % 2) == 0;
        NumericTest isNonNegative = num -> num >= 0;
        System.out.println("4 делится на 2 без остатка? " + isEven.test(4));
        System.out.println("-2 положительное число? " + isNonNegative.test(-2));
    }

    //первый пример, сортировка массива методом Arrays.sort()
    //можно как использовать класс реализующий интерфейс Comparator
    static class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    public static void sort() {
        String[] str = {"Dima", "Vasya", "Vova", "Rostislav", "Artem"};
        Arrays.sort(str); //Стандартная сортировка по алфавиту
        System.out.println(Arrays.toString(str));

        Arrays.sort(str, new LengthComparator()); //Сортировка по длине символов при помощи внутреннего класса
        System.out.println(Arrays.toString(str));

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.hashCode() - o1.hashCode();
            }
        }); //сортировка анонимным внутренним классом по хэшкоду
        System.out.println(Arrays.toString(str));

        //сортировка с использованием лямбда выражения
        Arrays.sort(str, (s1, s2) -> s1.codePointAt(0) - s2.codePointAt(0));
        System.out.println(Arrays.toString(str));
    }

    //тест работы с лямбда выражением на примере собственного интерфейса
    //который принимает одно число и возвращает значение boolean
    @FunctionalInterface
    interface NumericTest {
        boolean test(int num);
    }
}
