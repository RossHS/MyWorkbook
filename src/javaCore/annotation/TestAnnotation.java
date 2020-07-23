package javaCore.annotation;

/**
 * Стандартный синтаксис аннотаций
 * Все интерфейсы аннотаций неявно расширяют интерфейс java.lang.annotation.Annotation.
 * <p>
 * Элемент аннотации может принимать один из следующих типов.
 * • Примитивный тип (int, short, long, byte, char, double, float или boolean).
 * • Строковый тип String.
 * • Тип Class (с каким-нибудь необязательным параметром вроде Class(<? extends MyClass>).
 * • Перечислимый тип enum.
 * • Тип аннотации.
 * • Массив перечисленных выше типов (массив массивов не является допустимым типом элемента аннотации).
 *
 * @author Ross Khapilov
 * @version 1.0 01.03.2019
 */
public @interface TestAnnotation {
    int num();

    boolean bool() default false;

    String text() default "none";

    Class<? extends Basic> classic();

    enum Status {ERROR, OK, WARNING}

    Status status() default Status.OK;

    Override rid() default @Override;

    String[] strs();
}


@Deprecated
class TestDriveAnno{
    static void getN( String s){

    }

}
