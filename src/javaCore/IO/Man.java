package javaCore.IO;

import java.io.Serializable;

/**
 * Для примера
 *
 * @author Ross Khapilov
 * @version 1.0 05.01.2019
 */
public class Man implements Serializable {
    private int age;
    private String name;
    private int salary;

    public Man(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + "\'" +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
