package javaCore.collections;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * EnumSet - коллекция для множества элементов, относящихся к Enum типу, так перечислений ограниченное количество, то
 * класс EnumSet реализован внутренним образом в виде битовой последовательности, в каждом бите устанавливается 1, если
 * соответствующее значение перечисления присутствует в множестве. У данном коллекции отсутствуют конструкторы, т.е.
 * для создания такой коллекции используем статический фабричный метод.
 *
 * @author Ross Khapilov
 * @version 1.0 created on 24.12.2017
 */
public class EnumSetTest {
    enum Weekday {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    EnumSet<Weekday> always = EnumSet.allOf(Weekday.class);
    EnumSet<Weekday> never = EnumSet.noneOf(Weekday.class);
    EnumSet<Weekday> workDay = EnumSet.range(Weekday.MONDAY, Weekday.FRIDAY);
    EnumSet<Weekday> mwf = EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
//    В документации на прикладной программный интерфейс API класса EnumSet можно
//    обнаружить необычные параметры вроде Е extends Enum<E> Такое обозначение просто означает,
//    что "E относится к перечислимому типу". Перечислимые типы расширяют обобщенный класс
//    E m m Например, перечислимый тип Weekday расширяет класс Enum<Weekday>.

    EnumMap<Weekday,Man> enumMap = new EnumMap<>(Weekday.class);

}
