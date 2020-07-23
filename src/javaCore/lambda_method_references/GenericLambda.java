package javaCore.lambda_method_references;

/**
 * Указывать параметры типа в самом лямбда выражении нельзя, так что мы указываем при объявлении ссылки
 *
 * @author Ross Khapilov
 * @version 1.0 created on 08.01.2018
 */
public class GenericLambda {
    public static void main(String[] args) {
        SomeFunc<String> reverse = s -> {
            String result = "";
            for (int i = s.length() - 1; i >= 0; i--) {
                result += s.charAt(i);
            }
            return result;
        };
        System.out.println(reverse.func("abc"));
    }

    @FunctionalInterface
    interface SomeFunc<T> {
        T func(T t);
    }
}
