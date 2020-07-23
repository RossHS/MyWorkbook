package javaCore.generics;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Ограничения дженериков!
 * <p>
 * 1. Простые типы нельзя использовать в качестве параметра типа.
 * {@link RestrictionsOfGenerics#example1() example1}
 * <p>
 * 2. Во время выполнения можно запрашивать только базовые типы.
 * {@link RestrictionsOfGenerics#example2() example2}
 * <p>
 * 3. Нельзя создать массив обобщенного типа.
 * {@link RestrictionsOfGenerics#example3() example3}
 * <p>
 * 4. Предупреждение о переменном числе аргументов.
 * {@link RestrictionsOfGenerics#example4(Collection, Object[])}  example4}
 * <p>
 * 5. Нельзя создать объекты переменных типов.
 * {@link RestrictionsOfGenerics#example5() example5}
 * <p>
 * 6. Нельзя создать обобщенный массив.
 * {@link RestrictionsOfGenerics#example6() example6}
 * <p>
 * 7. Переменные типа в статическом контексте обобщенного класса недействительны.
 * {@link RestrictionsOfGenerics#example7() example7}
 * <p>
 * 8. Нельзя генерировать или перехватывать экземпляры обобщенного класса в виде исключений
 * {@link  RestrictionsOfGenerics#example8(Class t) example8}
 * <p>
 * 9. Преодоление ограничения на обработку проверяемых исключений
 * {@link RestrictionsOfGenerics#example9(Throwable t) example9}
 * <p>
 * 10. Конфликты после стирания типов
 * {@link RestrictionsOfGenerics#example10() example10}
 *
 * @author Ross Khapilov
 * @version 1.0 created on 28.03.2018
 */
public class RestrictionsOfGenerics<S> {
    /**
     * 1 ограничение. Следует использовать классы оболочки. Причина в raw (сыром) базовом типе объектов Object,
     * переменные типа при выполнении программы стираются и заменяются ограниченными типами
     */
    private static void example1() {
        //недопустимо
        //ArrayList<int> ari;
        ArrayList<Integer> arI;
    }

    /**
     * 2 ограничение. Т.е. не получится пользоваться оператором instanceof для определения точного типа у класса.
     */
    private static void example2() {
        Pair<String> ps = new Pair<>();
        Pair<Number> pn = new Pair<>();
        System.out.println(ps.getClass().getName());
//        javaCore.generics.Pair
        System.out.println(pn.getClass().getName());
//        javaCore.generics.Pair
    }

    /**
     * 3 ограничение. После стирания типа массив просто станет Pair[10], а не Pair<String>[10].
     * Следует пользоваться коллекциями. Но можно создать метод с переменным числом аргументов для создания такого
     * массива, что не рекомендуется!
     */
    private static void example3() {
        //Pair<String>[] pairs = new Pair<String>[10];
        ArrayList<Pair<String>> pairs = new ArrayList<>();
    }

    /**
     * 4 предупреждение. Т.к. переменный параметр ts по сути является массивом, но здесь правила ослаблены.
     * Следует использовать аннотацию @SafeVarargs.
     */
    @SafeVarargs
    private static <T> void example4(Collection<T> collection, T... ts) {
        for (T a : ts) collection.add(a);
    }

    /**
     * 5 ограничение. При стирании типов T() изменится на Object(), что естественно является неверным.
     */
    private static <T> void example5() {
//        T a = new T();
    }

    /**
     * 6 ограничение. При стирании типов T() изменится на Object(), но можно воспользоваться приведением типов.
     */
    private static <T> void example6() {
//        T[] a = new T[10];
        Object[] a = new Object[10];
        T[] t = (T[]) a;
    }

    /**
     * 7 ограничение. На переменные типа нельзя ссылаться в статических полях или методах. Ведь после стирания типов
     * остается только один класс и только одно поле. Именно по этой причине статические поля и методы с переменными
     * типа просто недопустимы.
     */
    private static void example7() {
//        private static void example7(S e) {
//        }
    }

    /**
     * 8. Генерировать или перехватывать объекты обобщенного класса в виде исключений не допускается. На самом деле
     * обобщенный класс не может расширять класс Throwable. Например, приведенное ниже определение обобщенного класса
     * не будет скомпилировано. Так же, дженерик нельзя использовать в блоке catch.
     * НО! указывать дженерик в throws допустимо
     */
    private static <T extends Throwable> void example8(Class<T> t) throws T {
//        class Problem<T> extends Throwable {
//
//        }
//      Дело в том, что блоки catch(Problem<String> e) или catch(Problem<Integer> e) будут восприниматься одинаково, т.к.
//      дженерик сотрется, т.е. будет ситуация похожая на 2 ограничение

//        try{
//
//        }catch (T e){
//            e.printStackTrace();
//        } т.к. T просто заменится на Throwable
    }

    /**
     * 9. Как гласит основополагающий принцип обработки исключений в Java, для все проверяемых исключений должны быть
     * предоставлены обработчики. Но это ограничение можно преодолеть, используя обобщения. И главным средством для
     * достижения этой цели служит следующий метод:
     * Допустим, что этот метод содержится в классе Block. Если сделать приведенный ниже вызов, то компилятор
     * посчитает t непроверяемым исключением. Block.<RuntimeException>throwAs(t);
     */
    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void example9(Throwable e) throws T {
        throw (T) e;
    }

    /**
     *Не допускается создавать условия, приводящие к конфликтам после стирания обобщенных типов.
     *  Допустим, в обобщенный класс Pair вводится метод equals (). Рассмотрим далее класс Pair<String>. По существу,
     *  в нем имеются два метода equals ():
     *  boolean equals(String) // определен в обобщенном классе Pair<T>
     * boolean equals(Object) // унаследован от класса Object
     * Но интуиция приводит к заблуждению. В результате стирания типов метод boolean equals (Т) становится методом
     * boolean equals (Object), который вступает в конфликт с методом Object .equals (). Разумеется, для разрешения
     * подобного конфликта следует переименовать метод, из-за которого возникает конфликт.
     * В описании обобщений приводится другое правило: "Для поддержки преобразования путем стирания типов накладывается
     * следующее ограничение: класс или переменная типа не могут одновременно быть подтипами двух типов, представляющих
     * собой разные виды параметризации одного и того же интерфейса". Например, следующий код недопустим:
     * class Employee implements Comparable<Employee> { . . . }
     * class Manager extends Employee implements Comparable<Manager>
     * { . . . } / / ОШИБКА!
     * В этом коде класс Manager должен одновременно реализовать оба типа, Comparable<Employee> и Comparable<Manager>,
     * представляющие собой разные виды параметризации одного и того же интерфейса. Непонятно, каким образом это
     * ограничение согласуется со стиранием типов. Ведь вполне допустим следующий необобщенный вариант реализации
     * интерфейса Comparable:
     * class Employee implements Comparable { . . . }
     * class Manager extends Employee implements Comparable { . . . }
     * Причина недоразумения намного утонченнее, поскольку может произойти конфликт с синтезированными мостовыми
     * методами. Класс, реализующий обобщенный интерфейс Comparable<X>, получает приведенный ниже мостовой метод.
     * Но дело в том, что наличие двух таких методов с разными обобщенными типами X не допускается.
     * public int compareTo(Object other) { return compareTo((X) other); }
     */
    private static void example10() {


    }



    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        example4(strings, "a", "d", "R");
        try {
            //   выполнить нужные действия
        } catch (Throwable t) {
            RestrictionsOfGenerics.<RuntimeException>example9(t);
        }
    }
}
