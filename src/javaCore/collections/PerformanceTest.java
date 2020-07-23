package javaCore.collections;

import java.nio.charset.Charset;
import java.util.*;

/**
 * Сравнение времени работы добавления и удаления элементов, перебор элементов
 * в ArrayList и LinkedList
 *
 * @author Ross Khapilov
 * @version 1.0 created on 19.12.2017
 */
public class PerformanceTest {
    private static Date time;
    private static List<String> arrayList = new ArrayList<>();
    private static List<String> linkedList = new LinkedList<>();
    private static String[] strings = fillString(1_000_000);

    //Получаем массив String[] со случайным содержимым
    private static String[] fillString(int length) {
        String[] str = new String[length];
        for (int i = 0; i < str.length; i++) {
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            str[i] = new String(array, Charset.forName("UTF-8"));
        }
        return str;
    }

    private static void setUpTime() {
        time = new Date();
    }

    private static long getTime() {
        return new Date().getTime() - time.getTime();
    }

    private static void fillTheCollection(List<String> list) {
        for (String string : strings) {
            list.add(string);
        }
    }

    private static void removeTheElement(List<String> list) {

        list.removeIf(e -> e.contains("a"));

    }

    public static void main(String[] args) {

        setUpTime();
        fillTheCollection(arrayList);
        System.out.println("Время на заполнение коллекции arrayList " + getTime());

        setUpTime();
        fillTheCollection(linkedList);
        System.out.println("Время на заполнение коллекции LinkedList " + getTime());
        setUpTime();

        setUpTime();
        removeTheElement(arrayList);
        System.out.println("Время на удаление из середины коллекции arrayList " + getTime());

        setUpTime();
        removeTheElement(linkedList);
        System.out.println("Время на удаление из середины коллекции LinkedList " + getTime());
    }
}
