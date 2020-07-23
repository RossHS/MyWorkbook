package javaCore.lambda_method_references;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;

/**
 * С лямбда-выражениями связано еще одно очень важное средство, называемое ссылкой на метод. Такая ссылка позволяется
 * обращаться к методу, не вызывая его.Она связана с лямбда-выражениями потому, что ей также требуется контекст целевого
 * типа, состоящий из совместимого функционального интерфейса. Имеются разные виды ссылок на методы.
 * <P>1.Ссылки на статические методы - Класс::СтатическийМетод
 * <P>2.Ссылки на методы экземпляра  - Объект::МетодЭкземпляра, Класс::МетодЭкземпляра
 * <P>3.Ссылки на обобщенные методы  - Класс::<ОбобщенныйТип>МетодЭкземпляра
 * <P>4.Ссылки на конструкторы       - Класс::new
 * <P> так же для допускается использовать ключевые слова this::МетодЭкземпляра и super::МетодЭкземпляра.
 * Т.е. x -> this.equals(x) однозначно this::equals
 *
 * @author Ross Khapilov
 * @version 1.0 created on 09.01.2018
 */
public class MethodReference {
    public static void main(String[] args) {
        staticMethodReference(); //Пример с ссылкой на статический метод

        //второй пример с ссылкой на статический метод
        puk((left, right) -> Math.pow(left, right),3,2);
        puk(Math::pow,12,2); //Тоже самое


    }

    public static void staticMethodReference() {
        //первый пример
        List<String> names = new ArrayList<>(Arrays.asList("Ivan", "Andrey", "Artem", "Vladimir"));
        Consumer<String> consumer = System.out::println; //e-> System.out.println(e) тоже самое
        names.forEach(consumer);
    }

    private static void puk(DoubleBinaryOperator intBinaryOperator, double left, double right) {
        System.out.println(intBinaryOperator.applyAsDouble(left,right));
    }
}
