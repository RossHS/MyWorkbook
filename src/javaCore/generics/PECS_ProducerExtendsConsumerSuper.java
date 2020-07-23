package javaCore.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Особенность wildcard с верхней и нижней границей дает дополнительные фичи, связанные с безопасным использованием типов.
 * Из одного типа переменных можно только читать, в другой — только вписывать (исключением является возможность записать
 * null для extends и прочитать Object для super). Чтобы было легче запомнить, когда какой wildcard использовать,
 * существует принцип PECS — Producer Extends Consumer Super.
 * <p>
 * Если мы объявили wildcard с extends, то это producer. Он только «продюсирует», предоставляет элемент из контейнера,
 * а сам ничего не принимает.
 * <p>
 * Если же мы объявили wildcard с super — то это consumer. Он только принимает, а предоставить ничего не может.
 *
 * @author Ross Khapilov
 * @version 1.0 19.07.2018
 */
public class PECS_ProducerExtendsConsumerSuper {
    public static void main(String[] args) {
        List<? extends Number> integers = Arrays.asList(1, 2, 3);
        //нельзя добавить, но можно извлечь!
        //integers.add(2);
        System.out.println(integers.get(0));

        //Все тоже самое верно и для методов.
        //addWild(integers).add(1);
        System.out.println(addWild(integers).get(1));

        List<? super Number> objects = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(objects.get(1).getClass());
    }

    private static List<? extends Number> addWild(List<? extends Number> numbers) {
        //numbers.add(2);
        return numbers;
    }
}
