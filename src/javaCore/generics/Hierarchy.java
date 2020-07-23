package javaCore.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 09.04.2018
 */
public class Hierarchy<T> {
    private T someType;

    public Hierarchy(T someType) {
        this.someType = someType;
    }

    public void setSomeType(T someType) {
        this.someType = someType;
    }

    public static void main(String[] args) {
        //В данном случае принцип полиморфизма сохраняется и все работает как надо
        //т.к. Animal anim = new Dog(...) соответствует этим принципам
        Hierarchy<Animal> animalHierarchy1 = new Hierarchy<>(new Animal(1, "Vasya"));
        Hierarchy<Animal> animalHierarchy2 = new Hierarchy<>(new Dog(2, "Lyona", 12));

        //Недопустимо, так как между ними отсутствует наследование
        //Hierarchy<Animal> hierarchy = new Hierarchy<Dog>(new Dog(2,"Asya",17));

        //Допустимо, но не рекомендуется, т.к. не будет работать типовая безопасность на этапе компиляции,
        // т.е. будем получать те же ошибки, но на этапе выполнения
        Hierarchy hierarchy = new Hierarchy<Animal>(new Animal(2, "Bart"));
        //hierarchy.setSomeType("String"); скомпилируется, но потом получим исключение

        List<String> strings = new ArrayList<>();

        System.out.println(animalHierarchy1.someType.getClass().getName());
        System.out.println(animalHierarchy2.someType.getClass().getName());
    }
}


/**
 * Вспомогательные классы для примеры иерархии
 */
class Animal {
    private int age;
    private String name;

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

class Dog extends Animal {
    private int size;

    public Dog(int age, String name, int size) {
        super(age, name);
        this.size = size;
    }
}