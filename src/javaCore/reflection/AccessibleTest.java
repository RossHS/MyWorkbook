package javaCore.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/**
 * Реализация доступа к закрытым полям объекта.
 *
 * @author Ross Khapilov
 * @version 1.0 23.09.2018
 */
public class AccessibleTest {
    public static void main(String[] args) throws IllegalAccessException {
        A a = new A("Вася", 40);
        Class cl = a.getClass();
        Field[] f = cl.getDeclaredFields();
        AccessibleObject.setAccessible(f, true);
        for (Field field : f) {
            System.out.println(field.getName() + " " + field.get(a));
            if (field.get(a) instanceof String) field.set(a, "Петя");
        }
        System.out.println(a);
    }
}

class A {
    private String name;
    private int age;

    public A(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
