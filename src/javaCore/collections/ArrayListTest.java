package javaCore.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * ArrayList основан на обычном массиве, динамически увеличивает размер при добавление элемента
 * и уменьшает при его удалении. ArrayList более предсказуем для процессора, с точки зрения расположения данных.
 * Это массив, а там элементы расположены последовательно, занимая непрырывную область памяти.
 * Это хорошо, так как позволяет подгружать данные в кэши процессора без cache miss'ов.
 * Процессор не простаивает, ожидая данные из оперативной памяти.
 * Главный недостаток - при добавление или удалении элемента создается новый массив, что может занять определенное
 * время, по-этому, если для коллекции постоянно выполняются такие операцию, то рекомендуется использовать LinkedList
 * <p>
 * Выбор ArrayList практически всегда является предпочтительным.
 *
 * @author Ross Khapilov
 * @version 1.0 created on 18.12.2017
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList =
                new ArrayList<>(Arrays.asList("Москва", "Тверь", "Питер", "Новосибирск", "Калининград", "Омкс"));

        String str = stringArrayList.get(1);
        stringArrayList.add("sda");
        System.out.println(str);

        //пример изменения размера коллекции при удалении из нее элемента
        System.out.println(stringArrayList.size());
        stringArrayList.remove(5);
        System.out.println(stringArrayList.size());

        //получили поддиапазон и удалили его, это отразилось на основном ArrayList
        List<String> list = stringArrayList.subList(1, 3);
        System.out.println(list);
        list.clear();

        System.out.println(stringArrayList);
    }
}
