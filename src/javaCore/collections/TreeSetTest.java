package javaCore.collections;

import java.util.*;

/**
 * TreeSet реализует древовидное множество, подобное хэш-множеству, но с одним усовершенствованием-
 * это отсортированная коллекция. В нее можно вводить элементы в любом порядка и они окажутся автоматически
 * отсортированными. Классы для коллекции обязаны реализовывать интерфейс Comparable, либо можно использовать
 * лямбда выражение/анонимный внутренний класс с реализацией интерфейса Comparator
 *
 * @author Ross Khapilov
 * @version 1.0 created on 22.12.2017
 */
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<String> sorted = new TreeSet<>();
        sorted.add("Bob");
        sorted.add("Amy");
        sorted.add("Carl");
        for (String s : sorted) System.out.println(s);

        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 142));
        parts.add(new Item("Modem", 9234));
        System.out.println(parts);

        NavigableSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}

class Item implements Comparable<Item> {
    private String description;
    private int partNumber;

    public Item(String aDescription, int aPartNumber) {
        description = aDescription;
        partNumber = aPartNumber;
    }

    public String getDescription() {
        return description;
    }

    public int getPartNumber() {
        return partNumber;
    }

    @Override
    public String toString() {
        return "[description= " + description + ", partNumber= " + partNumber + "]";
    }

    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    @Override
    public int compareTo(Item o) {
        int diff = Integer.compare(partNumber, o.partNumber);
        return diff != 0 ? diff : description.compareTo(o.description);
    }
}
