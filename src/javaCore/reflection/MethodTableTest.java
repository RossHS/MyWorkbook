package javaCore.reflection;

import java.lang.reflect.Method;

/**
 * В этой программе демонстрируется применение рефлексии
 * для вызова методов, которой лучше не пользоваться, т.к.
 * <p>
 * такой стиль программирования обычно неудобен и часто приводит к ошибкам.
 * Что, если, например, вызвать метод invoke () с неверно заданными параметрами?
 * В этом случае метод invoke () сгенерирует исключение. Кроме того, параметры метода invoke ()
 * и возвращаемое им значение обязательно должны быть типа Object.
 * А это влечет за собой приведение типов в соответствующих
 * местах кода. В итоге компилятор будет лишен возможности тщательно проверить исходный
 * код программы. Следовательно, ошибки в ней проявятся только на стадии тестирования,
 * когда исправить их будет намного труднее. Более того, программа, использующая
 * механизм рефлексии для получения указателей на методы, работает заметно
 * медленнее, чем программа, непосредственно вызывающая эти методы.
 * По этим причинам пользоваться объектами типа Method рекомендуется только
 * в самом крайнем случае. Намного лучше применять интерфейсы и внутренние
 * классы, рассматриваемые в следующей главе. В частности, следуя указаниям разработчиков
 * Java, объекты типа Method не рекомендуется применять для организации
 * функций обратного вызова, поскольку для этой цели вполне подходят интерфейсы,
 * позволяющие создавать программы, которые работают намного быстрее и надежнее.
 *
 * @author Ross Khapilov
 * @version 1.0 24.09.2018
 */
public class MethodTableTest {
    public static void main(String[] args) throws NoSuchMethodException {
        //получить указатели на методы square() и sqrt()
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        //вывести значения x и у в табличном виде
        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }

    /**
     * Возвращает квадрат числа
     *
     * @param x Число
     * @return Квадрат числа
     */
    public static double square(double x) {
        return x * x;
    }

    /**
     * Выводит в табличном виде значения х и у указанного метода
     *
     * @param from Нижняя граница значений х
     * @param to   Верхняя граница значений х
     * @param n    Количество строк в таблице
     * @param f    Метод, получающий и возвращающий
     *             значение типа double
     */
    public static void printTable(double from, double to, int n, Method f) {
        //Вывести сигнатуру метода в заголовок таблицы
        System.out.println(f);
        double dx = (to - from) / (n - 1);
        for (double i = from; i <= to; i += dx) {
            try {
                double y = (double) f.invoke(null, i);
                System.out.printf("%10.4f | %10.4f%n", i, y);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
