package javaCore.reflection;

/**
 * Во время выполнения программы исполняющая система Java всегда осуществляет
 * динамическую идентификацию типов объектов любых классов. Получаемые в итоге
 * сведения используются виртуальной машиной для выбора подходящего вызываемого
 * метода.
 *
 * @author Ross Khapilov
 * @version 1.0 21.09.2018
 */
public class ClassTest {
    /**
     * Есть три различных способа создать объект класса Class
     */
    private static void createClass() throws ClassNotFoundException {
        Class c1 = "STRING".getClass();
        Class c2 = String.class;
        Class c3 = Class.forName("java.lang.String");
        //они все равны
        if (c1 == c2 && c2 == c3) System.out.println("Ссылки указывают на один и тот же объект");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        createClass();

        //Можно создать объект на основе объекта Класс
        String s = "java.util.Date";
        @SuppressWarnings("deprecation")
        Object m = Class.forName(s).newInstance();

    }
}
