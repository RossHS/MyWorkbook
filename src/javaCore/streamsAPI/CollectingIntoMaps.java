package javaCore.streamsAPI;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ross Khapilov
 * @version 1.0 26.09.2018
 */
public class CollectingIntoMaps {
    public static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return getClass().getName() + "[id=" + id + ", name=" + name + "]";
        }
    }

    public static Stream<Person> people() {
        return Stream.of(new Person(1001, "Peter"),
                new Person(1002, "Paul"),
                new Person(1003, "Mary"));
    }

    public static void main(String[] args) {
        Map<Integer, String> idToName = people().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println("idToName: " + idToName);

        //В общем случае, когда значения должны быть конкретными элементами, в качестве второго аргумента
        // данному методу предоставляется функция Function.identity():
        Map<Integer, Person> idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);

        idToPerson = people().collect(Collectors.toMap(Person::getId,
                Function.identity(),
                //если присутствуют по одному ключу два значения
                (existingValue, newValue) -> {
                    throw new IllegalStateException();
                },
                //нужно для получения конкретной коллекции
                TreeMap::new));
        System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locales.collect(
                Collectors.toMap(
                        Locale::getDisplayLanguage,
                        l -> l.getDisplayLanguage(l),
                        (existingValue, newValue) -> existingValue));
        System.out.println("languageNames: " + languageNames);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryLanguageSets = locales.collect(Collectors.toMap(
                Locale::getDisplayCountry,
                l -> Collections.singleton(l.getDisplayLanguage()), (a, b) -> { // объединить множества а и b
                    Set<String> union = new HashSet<>(a);
                    union.addAll(b);
                    return union;
                }));
        System.out.println("countryLanguageSets: " + countryLanguageSets);
    }
}
