package javaCore.generics;

import java.util.ArrayList;

/**
 * Дженерики (обобщения) - появились в java 5. Обобщенное программирование означает написание кода, который может быть
 * неоднократно использован с объектами самых разных типов. Так, если нет желания программировать отдельные классы для
 * составления коллекций из объектов типа String и File, достаточно собрать эти объекты в коллекцию, воспользовавшись
 * единственным обобщенным классом ArrayList. И это всего лишь один простой пример обобщенного программирования.
 * <p>
 * <p>
 * Преимущества:
 * <p>
 * 1) Обеспечение безопасности типов
 * <p>
 * 2) Пригодность для повторного использования
 * <p>
 * 3) Высокая надежность
 *
 * @author Ross Khapilov
 * @version 1.0 created on 25.03.2018
 */
public class MainInfo {

    /**
     * Пример обобщенного метода
     */
    private static <T, V> void showTime(T obj1, V obj2) {
        System.out.println("obj1 = [" + obj1.getClass().getName() +
                "], obj2 = [" + obj2.getClass().getName() + "]");
    }

    public static void main(String[] args) {
        //преимущества использования обобщений
        ArrayList list = new ArrayList();
        //Нет контроля над типами объектов добавляемых в коллекцию, что может приводить к ошибкам
        list.add("Abc");
        list.add(123);
        String listStr = (String) list.get(0);
        System.out.println(listStr);

        ArrayList<String> stringArrayList = new ArrayList<>(); //даймонд- в Java 7 появилась возможность
        // не повторять тип обобщения при создания объектов, он автоматически возьмется из обобщения в объявлении ссылки

        stringArrayList.add("Abcd");
        //stringArrayList.add(123); не скомпилируется
        listStr = stringArrayList.get(0);
        System.out.println(listStr);

        showTime("abc",1);
    }
}
