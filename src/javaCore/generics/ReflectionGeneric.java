package javaCore.generics;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * С помощью рефлексии произвольные объекты можно анализировать во время выполнения. Если же объекты являются
 * экземплярами обобщенных классов, то с помощью рефлексии удается получить немного сведений о параметрах обобщенного
 * типа, поскольку они стираются. Тем не менее в последующих разделах поясняется, какие сведения об обобщенных классах
 * все-таки позволяет выявить рефлексия.
 * <p>
 * Класс Class теперь является обобщенным. Например, String.class — на самом деле объект (по существу, единственный)
 * класса Class<String>. Параметр типа удобен, потому что он позволяет методам обобщенного класса Class<Т> быть более
 * точными в отношении возвращаемых типов. В следующих методах из класса Class<T> используются преимущества
 * параметра типа:
 * newlnstance()
 * Т cast(Object obj)
 * T [] getEnumConstants()
 * Class<? super T> getSuperclass()
 * Constructor<T> getConstructor(Class... parameterTypes)
 * Constructor<T> getDeclaredConstructor(Class... parameterTypes)
 * <p>
 * Одной из замечательных особенностей обобщений в Java является стирание обобщенных
 * типов в виртуальной машине. Как ни странно, но классы, подвергшиеся
 * стиранию типов, все еще сохраняют некоторую память о своем обобщенном происхождении.
 * Например, базовому классу Pair известно, что он происходит от обобщенного
 * класса Pair<T>, несмотря на то, что объект типа Pair не может отличить,
 * был он сконструирован как объект типа Pair<String> или же как объект типа
 * Pair<Employee>.
 * Аналогично метод
 * public static Comparable min(Comparable[] a)
 * является результатом стирания типов в приведенном ниже обобщенном методе.
 * public static <Т extends Comparable<? super Т » T min(T[] а)
 * Прикладной программный интерфейс API для рефлексии можно использовать,
 * чтобы определить следующее.
 * • Имеет ли обобщенный метод параметр типа Т.
 * • Имеет ли параметр типа ограниченный подтип, который сам является обобщенным.
 * • Имеет ли ограничивающий тип подставляемый параметр.
 * • Имеет ли подставляемый параметр ограниченный супертип.
 * • Имеет ли обобщенный метод обобщенный массив в качестве своего параметра.
 *
 * @author Ross Khapilov
 * @version 1.0 created on 15.04.2018
 */
public class ReflectionGeneric {
    public static void main(String[] args) throws Exception {
        Class<String> stringClass = String.class;

        System.out.println(stringClass.getName());
        System.out.println(stringClass.getInterfaces().length);
        System.out.println("////////////////////////////////////////////");

        //Прочесть имя класса
        String name;
        if (args.length > 0) name = args[0];
        else {
            try (Scanner in = new Scanner(System.in)) {
                System.out.println("Enter class name (e.g. java.util.Collections): ");
                name = in.next();
            }
        }

        try {
            //вывести обобщенные сведения о классе и его открытых методах
            Class<?> c1 = Class.forName(name);
            printClass(c1);
            for (Method m : c1.getDeclaredMethods()) {
                printMethod(m);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printClass(Class<?> cl) {
        System.out.println(cl);
        printTypes(cl.getTypeParameters(), "<", ", ", ">", true);
        Type sc = cl.getGenericSuperclass();
        if (sc != null) {
            System.out.print(" extends ");
            printType(sc, false);
        }
        printTypes(cl.getGenericInterfaces(), " implements ", ", ", "", false);
        System.out.println();
    }

    public static void printMethod(Method m) {
        String name = m.getName();
        System.out.print(Modifier.toString(m.getModifiers()));
        System.out.print(" ");
        printTypes(m.getTypeParameters(), "<", ", ", "> ", true);

        printType(m.getGenericReturnType(), false);
        System.out.print(" ");
        System.out.print(name);
        System.out.print("(");
        printTypes(m.getGenericParameterTypes(), "", ", ", "", false);
        System.out.println(")");
    }

    public static void printTypes(Type[] types, String pre, String sep, String suf, boolean isDefinition) {
        if (pre.equals(" extends ") && Arrays.equals(types, new Type[]{Object.class}))
            return;
        if (types.length > 0) System.out.print(pre);
        for (int i = 0; i < types.length; i++) {
            if (i > 0) System.out.print(sep);
            printType(types[i], isDefinition);
        }
        if (types.length > 0) System.out.print(suf);
    }

    public static void printType(Type type, boolean isDefinition) {
        if (type instanceof Class) {
            Class<?> t = (Class<?>) type;
            System.out.print(t.getName());
        } else if (type instanceof TypeVariable<?>) {
            TypeVariable<?> t = (TypeVariable<?>) type;
            System.out.print(t.getName());
            if (isDefinition)
                printTypes(t.getBounds(), " extends ", " & ", "", false);
        } else if (type instanceof WildcardType) {
            WildcardType t = (WildcardType) type;
            System.out.print("?");
            printTypes(t.getUpperBounds(), " extends* ", " & ", "", false);
            printTypes(t.getLowerBounds(), " super ", " & ", "", false);
        } else if (type instanceof ParameterizedType) {
            ParameterizedType t = (ParameterizedType) type;
            Type owner = t.getOwnerType();
            if (owner != null) {
                printType(owner, false);
                System.out.print(".");
            }
            printType(t.getRawType(), false);
            printTypes(t.getActualTypeArguments(), "<", ", ", ">", false);
        } else if (type instanceof GenericArrayType) {
            GenericArrayType t = (GenericArrayType) type;
            System.out.print("");
            printType(t.getGenericComponentType(), isDefinition);
            System.out.print("[]");
        }
    }

    //сопоставление типов с помощью параметров Class<T>
    public static <T> Pair<T> makeT(Class<T> t) throws Exception {
        @SuppressWarnings("deprecation")
        Pair<T> pair = new Pair<>(t.newInstance(), t.newInstance());
        return pair;
    }
}
