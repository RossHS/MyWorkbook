package javaCore.generics;

/**
 * Дженерик можно ограничивать как сверху используя ключевое слово extends, так и снизу super.
 * <p>
 * extends - для ограничения можно использовать 1 класс (т.к. не множественного наследования) и сколько угодно
 * интерфейсов
 * </p>
 *
 * @author Ross Khapilov
 * @version 1.0 created on 05.04.2018
 */
public class ExtendsSuper {
    private static <T extends Number & Comparable> void test(T a) {

    }

    public static void main(String[] args) {
    }
}
