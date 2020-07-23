package kotlinCore.classAndInterfaces;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author Ross Khapilov
 * @version 1.0 15.07.2020
 */
public class VovavSet<T> {
    private int counter = 0;
    private HashSet<T> set = new HashSet<>();

    public int getCounter() {
        return counter;
    }

    public boolean add(T t) {
        counter++;
        return set.add(t);
    }

    public boolean addAll(Collection<? extends T> c) {
        counter += c.size();
        return set.addAll(c);
    }
}

class Test {
    public static void main(String[] args) {
        VovavSet<String> strings = new VovavSet<>();

        strings.add("LEra");
        strings.add("sdad");
        strings.addAll(Arrays.asList("Ad", "ad", "ads"));
        System.out.println(strings.getCounter());
    }
}
