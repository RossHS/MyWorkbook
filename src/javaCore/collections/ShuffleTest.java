package javaCore.collections;

import java.util.*;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 24.12.2017
 */
public class ShuffleTest {
    public static void main(String[] args) {
        ArrayList<Integer> numbers =new ArrayList<>();
        for (int i = 1; i <= 49 ; i++) {
            numbers.add(i);
        }
        //Перемешивает коллекцию в случайном порядке
        Collections.shuffle(numbers);
        List<Integer> winCombination = numbers.subList(0,6);
        Collections.sort(winCombination);
        System.out.println(winCombination);
    }
}
