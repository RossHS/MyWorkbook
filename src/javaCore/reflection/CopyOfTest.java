package javaCore.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Чтобы сделать это, нужно определить длину и тип элементов нового массива.
 * Длину можно получить с помощью метода Array. get Length (). Статический метод
 * getLength () из класса Array возвращает длину любого массива. А для того чтобы определить
 * тип элементов нового массива, необходимо выполнить следующие действия.
 * 1. Определить, какому именно классу принадлежит объект а.
 * 2. Убедиться в том, что он действительно является массивом.
 * 3. Воспользоваться методом getComponentType () из класса Class (определен
 * лишь для объектов типа Class, представляющих массивы), чтобы получить
 * требуемый тип массива.
 * <p>
 * Ниже приведен исходный код рассматриваемого здесь обобщенного метода.
 * public static Object goodCopyOf(Object a, int newLength)
 * {
 * Class cl = a.getClass();
 * if (!cl.isArray()) return null;
 * Class componentType = cl.getComponentType();
 * int length = Array.getLength(a);
 * Object newArray = Array.newlnstance(componentType, newLength);
 * System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
 * return newArray;
 * }
 * Следует, однако, иметь в виду, что метод goodCopyOf () можно применять для наращивания
 * массива любого типа, а не только массива объектов, как показано ниже.
 * int[] а = { 1, 2, 3, 4, 5 };
 * а = (int[]) goodCopyOf(а, 10);
 * Для этого параметр метода goodCopyOf () объявляется как относящийся к типу
 * Object, а не как массив объектов (т.е. типа Object []). Массив типа int [] можно преобразовать
 * в объект типа Object, но не в массив объектов!
 * <p>
 * <p>
 * В этой программе демонстрируется применение рефлексии
 * для манипулирования массивами
 *
 * @author Ross Khapilov
 * @version 1.0 24.09.2018
 */
public class CopyOfTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"A", "D", "V"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));

        System.out.println("Появится исключение");
        b = (String[]) badCopyOf(b, 10);
    }

    /**
     * Наращивание массива путем выделения нового массива и копирования в него прежних элементов
     *
     * @param a         Наращиваемый массив
     * @param newLength Новая длина массива
     * @return Возвращаемый массив, содержащий все элементы массива a, но он относится к типу Object[],
     * а не типу массива a[]
     */
    //БЕСПОЛЕЗНАЯ РЕАЛИЗАЦИЯ
    public static Object[] badCopyOf(Object[] a, int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }

    /**
     * Этот метод наращивает массив, выделяя новый массив
     * того же типа и копируя в него все прежние элементы
     *
     * @param a         Наращиваемый массив. Может быть массивом объектов или же массивом примитивных типов
     * @param newLength Длина нового массива
     * @return Возвращаемый наращенный массив, содержащий все элементы массива а
     */
    public static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if (!cl.isArray()) return null;
        Object newArray = Array.newInstance(cl.getComponentType(), newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(Array.getLength(a), newLength));
        return newArray;
    }
}
