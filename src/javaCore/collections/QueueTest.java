package javaCore.collections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Тест реализация интерфейса очереди на примере классов ArrayDeque и LinkedList
 * ArrayDeque работает по принципу циклического массива динамически расширяемого
 * LinkedList - связанный список, т.е. один элемент ссылается на другой
 * Обычно выбирают цикличный динамический массив из-за его быстроты,
 * его лучше выбирать если известен верхний предел количества элементов.
 * <p>
 * Очередь работает по принципу добавлен первым обработан первым
 * так же есть интерфейс Deque реализующий двустороннюю очередь т.е.
 * зашел первым- обработан первым/последним
 *
 * @author Ross Khapilov
 * @version 1.0 created on 17.12.2017
 */
public class QueueTest {
    public static void main(String[] args) {
        //6 элементов в массиве String
        String[] strings = {"Москва", "Тверь", "Питер", "Новосибирск", "Калининград", "Омкс"};
        ArrayDeque<String> arrayDqueue = new ArrayDeque<>(Arrays.asList(strings));
        System.out.println(arrayDqueue.size());

        //получаем первый элемент очереди и последний
        String sFirst = arrayDqueue.getFirst();
        String sLast = arrayDqueue.getLast();
        System.out.println(sFirst + " " + sLast);
        System.out.println();

        //извлекаем элементы сначала
        while (arrayDqueue.peek() != null) {
            System.out.println(arrayDqueue.pop());
        }
        //размер после извлечение 0
        System.out.println(arrayDqueue.size());

        LinkedList<String> listDqueue = new LinkedList<>(Arrays.asList(strings));
    }
}