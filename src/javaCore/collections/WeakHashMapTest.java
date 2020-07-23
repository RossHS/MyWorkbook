package javaCore.collections;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * WeakHashMap, фактически, хранит не пары "ключ - значение", а пары "слабая ссылка на ключ - значение".
 * Особенность слабых ссылок (WeakReference) состоит в том, что они игнорируются сборщиком мусора,
 * т.е. если на объект-ключ нет других ссылок, он уничтожается.
 * Т.е. происходит проверка на появление слабых ссылок, появление такой ссылки в очереди свидетельствует о том, что
 * ключ больше не используется, но хранится в коллекции. В таком случае связанный с ним элемент удаляется из
 * хэш-отображения WeakHashMap
 * <p>
 * Перед любым обращением к WeakHashMap (get(), put(), size() и т.д.) анализируются невалидные ссылки и
 * соответствующая пара удаляется.
 *
 * @author Ross Khapilov
 * @version 1.0 created on 24.12.2017
 */
public class WeakHashMapTest {
    public static void main(String[] args) {
        Map map = new WeakHashMap();
        Object obj = new Object(); // создаём объект
        map.put(obj, "object"); // кладём его в мапу
        System.out.println(map.size()); // в мапе один элемент
        obj = null; // чистим ссылку
        System.gc(); // играемся со сборщиком мусора
        System.runFinalization();
        System.out.println(map.size()); // мапа должна стать пустой
    }
}
