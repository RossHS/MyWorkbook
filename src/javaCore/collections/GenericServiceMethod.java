package javaCore.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Пример работы служебного метода интерфейса Collection.
 *
 * @author Ross Khapilov
 * @version 1.0 created on 18.12.2017
 */
public class GenericServiceMethod {
    public static void main(String[] args) {
        String[] strings = {"Москва", "Тверь", "Питер", "Новосибирск", "Калининград", "Омкс"};
        Collection<String> stringCollection = new ArrayList<>(Arrays.asList(strings));

        //true если коллекция содержит проверяемый элемент.
        System.out.println(stringCollection.contains("Москва"));

        //Возвращает размер коллекции.
        System.out.println(stringCollection.size());

        //Возвращает итератор для перебора коллекции.
        System.out.println(stringCollection.iterator());

        //Сравнивание идентичности коллекций.
        System.out.println(stringCollection.equals("Москва"));

        //Возвращает массив коллекции. т.е. мы передаем методу пустой массив, который он заполняет и возвращает
        String[] strArr = stringCollection.toArray(new String[stringCollection.size()]);
        System.out.println(strArr[0]);

        //Удаляем элемент коллекции.
        stringCollection.remove("Тверь");
        System.out.println("Удалили элемент \"Тверь\" " + stringCollection);

        //Проверяет, пустая ли коллекция.
        System.out.println(stringCollection.isEmpty());

        //Задаем условия, по которым будем удалять объекты из коллекции.
        stringCollection.removeIf(str -> str.toLowerCase().contains("в"));
        System.out.println("Удалили все элементы, что содержат букву в " + stringCollection);

        //Сплитератор — это интерфейс, который содержит 8 методов,
        //причём четыре из них уже имеют реализацию по умолчанию.
        //Оставшиеся методы — это tryAdvance, trySplit, estimateSize и characteristics.
        //Существуют также специальные модификации сплитератора для примитивных типов int, long и double:
        //они добавляют несколько дополнительных методов, чтобы избежать боксинга.
        //Сплитератор похож на обычный итератор. Основное отличие — умение разделиться (split)
        //на две части — лежит в основе параллельной работы потоков. Также в целях оптимизации сплитератор
        //имеет ряд флагов-характеристик и может сообщить точно или приблизительно свой размер.
        //Наконец, сплитератор никогда не модифицирует источник данных: у него нет метода remove как у итератора.
        stringCollection.spliterator();
    }
}