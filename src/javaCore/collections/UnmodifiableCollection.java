package javaCore.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * В классе Collections имеются методы для предоставления немодифицируемых коллекций (по сути, просто предоставляем
 * неизменяемый вьювер для нашей коллекции, когда она сама остается изменяемой). Такие представления вводят
 * динамическую проверку в существующую коллекцию. Если в ходе такой проверки обнаружится изменение коллекции, то
 * сгенерируется исключение и коллекция останется невредимой
 *
 * @author Ross Khapilov
 * @version 1.0 created on 24.12.2017
 */
public class UnmodifiableCollection {
    public static void main(String[] args) {

        ArrayList<String> arrayList =
                new ArrayList<>(Arrays.asList("Москва", "Тверь", "Питер", "Новосибирск", "Калининград", "Омкс"));
        arrayList.add("Краснодар");
        //Получаем неизменяемую коллекцию
        //по сути представляет собой статический внутренний класс реализующий интерфейс List/Set и т.п.
        List<String> unmodifi = Collections.unmodifiableList(arrayList);
        //unmodifi.add("Белгород"); //при попытке добавления получим исключение
        System.out.println(unmodifi);

        //но саму коллекцию можно изменять по первой ссылке
        arrayList.add("Белгород");
        System.out.println(unmodifi);
    }
}
