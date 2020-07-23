package javaCore.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap одна из двух реализаций коллекции с ключами (отображения). Поиск элементов происходит по ключам,
 * данная коллекция не является упорядоченной: порядок хранения элементов зависит от хэш-функции. Функции хеширование
 * и сравнения применяются только к КЛЮЧАМ, значения, связанные с ключами, не хешируются и не сравниваются.
 * HashMap следует пользоваться тогда, когда нам важно, чтобы не было одинаковых элементов в коллекции и нам не важно
 * расположение элементов в коллекции. Ключи должны быть однозначными, нельзя сохранить два значения по одинаковым
 * ключам. Если дважды вызвать метод put() с одним и тем же ключом, то второе заменит первое. Перебрать элементы
 * отображения по ключам и значениям проще всего методом forEach(), предоставив лямбда выражение, получающее ключ и
 * значение
 * <p>
 * Демонстрируется применение отображения с ключами типа String и значениями типа.
 *
 * @author Ross Khapilov
 * @version 1.0 created on 23.12.2017
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, Man> people = new HashMap<>();
        people.put("1", new Man("Вася"));
        people.put("2", new Man("Петя"));
        people.put("3", new Man("Иван"));
        people.put(null, new Man("Коля"));

        //вывести все элементы из отображения
        System.out.println(people);

        //удалить элемент из отображения
        people.remove("2");

        //заменить элемент в отображении
        people.put("3", new Man("Саша"));

        //найти значения по ключу
        System.out.println(people.get("1"));

        //перебрать все элементы в отображении
        for (Map.Entry<String, Man> entry : people.entrySet()) {
            String key = entry.getKey();
            Man value = entry.getValue();
            System.out.println("Ключ= " + key + " значение= " + value);
        }
        System.out.println();
        //или можно воспользоваться более современным способом
        people.forEach((k, e) -> System.out.println("Ключ= " + k + " значение= " + e));
    }
}

class Man {
    private String name;
    private int age;

    public Man(String name) {
        this.name = name;
    }

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Имя " + name;
    }

    @Override
    public int hashCode() {
        return age + name.hashCode();
    }
}