package javaCore.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashSet/LinkedHashMap подходит нам, если нам нужно запоминать порядок ввода элементов, таким образом, мы можем избегать
 * случайного расположения элементов в HashSet/HashMap
 *
 * @author Ross Khapilov
 * @version 1.0 created on 24.12.2017
 */
public class LinkedHashSet {
    public static void main(String[] args) {
        Map<String, Man> people = new LinkedHashMap<>();
        people.put("6", new Man("Ваня"));
        people.put("2", new Man("Петя"));
        people.put("1", new Man("Коля"));
        people.put("4", new Man("Федя"));
        Iterator iterator = people.keySet().iterator();
        Iterator iterator1 = people.values().iterator();
        //получим по порядку ввода элементы через итератор
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " " + iterator1.next());
        }

        System.out.println();

        //через анонимный класс переопределяя метод для того, чтобы удалять самый старый элемент,
        //в данном случае такое будет происходить после 4-ого элемента
        Map<String, Man> cache = new LinkedHashMap<>(128, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Man> eldest) {
                return size() > 4;
            }
        };
        cache.put("12",new Man("Влад"));
        cache.put("08", new Man("Рома"));
        cache.put("1", new Man("Стас"));
        cache.put("9", new Man("Славик"));
        cache.put("3", new Man("Антон"));
        //выведем последние 4 элемента
        cache.forEach((k,v)-> System.out.println("Ключ= " + k + " Значение= " + v));
    }
}
