package javaCore.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * Программа, способная анализировать возможности классов, называется рефлективной.
 * Рефлексия — очень мощный механизм, который можно применять для решения
 * перечисленных ниже задач. А в последующих разделах поясняется, как пользоваться
 * этим механизмом.
 * • Анализ возможностей классов в процессе выполнения программы.
 * • Проверка объектов при выполнении программы; например, с помощью рефлексии
 * можно реализовать метод toString(), совместимый со всеми классами.
 * • Реализация обобщенного кода для работы с массивами.
 * • Применение объектов типа Method, которые работают аналогично указателям
 * на функции в языках, подобных C++.
 * <p>
 * В этой программе рефлексия применяется для вывода
 * всех компонентов класса
 *
 * @author Ross Khapilov
 * @version 1.0 21.09.2018
 */
public class ReflectionTest {
    public static void main(String[] args) {
        //Извлечь имя класса из аргументов командной строки или введенных пользователем данных
        String name;
        if (args.length > 0) name = args[0];
        else {
            try (Scanner in = new Scanner(System.in)) {
                System.out.println("Enter class name (e.g. java.util.Date): ");
                name = in.next();
            }
        }

        try {
            //Вывести имя класса и суперкласса, если суперкласс не Object
            Class cl = Class.forName(name);
            Class superCl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print("class " + name);
            if (superCl != null && superCl != Object.class)
                System.out.print(" extends " + superCl.getName());
            System.out.print("{\n");
            printFields(cl);
            System.out.println();
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * Выводит все поля класса
     *
     * @param cl Класс
     */
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }

    /**
     * Выводит все конструкторы класса
     *
     * @param cl Класс
     */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String name = cl.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            //Вывести типы параметров
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println("};");
        }
    }

    /**
     * Выводит все методы класса
     *
     * @param cl Класс
     */
    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            Class returnType = m.getReturnType();
            String name = m.getName();

            System.out.print(" ");
            //Вывести модификаторы, возвращаемый тип и имя метода
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(returnType + " " + name + "(");
            //Вывести все типы параметров
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if(i>0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }
}
