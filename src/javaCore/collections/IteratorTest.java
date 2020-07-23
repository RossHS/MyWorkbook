package javaCore.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * интерфейс Iterator требуется для перебора коллекции,
 * при помощи метода next() можно обратиться к каждому элементу коллекции
 * по очереди, при конце коллекции сгенерирует исключение NoSuchElementException
 * по-этому его надо использовать в связке с методом hasNext() который проверяет,
 * имеется ли еще объект в коллекции, к которому можно обратиться.
 *
 * Порядок перебора коллекции зависит от ее типа.
 * Можно представить что итератор находится МЕЖДУ элементами,
 * а не как в С++ ориентируется на индекс массива
 * @author Ross Khapilov
 * @version 1.0 created on 17.12.2017
 */
public class IteratorTest {
    public static void main(String[] args) {
        String[] strings = {"Москва", "Тверь", "Питер", "Новосибирск", "Калининград", "Омкс"};
        Collection<String> stringCollection = new ArrayList<>(Arrays.asList(strings));
        Iterator<String> iterator = stringCollection.iterator();
        while (iterator.hasNext()) {
            String elem = iterator.next();
            System.out.println(elem);
        }
        System.out.println();
        //или
        for (String s : stringCollection) {
            System.out.println(s);
        }
    }
}
