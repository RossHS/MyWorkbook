package javaCore.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * HashSet - реализация коллекции на основе хэш-множества, в данную коллекцию добавляются лишь те элементы, что имеют
 * различный хэш-коды полученные методом hashCode() из класса Object - по-этому важно переопределять данный метод для
 * всех своих классов,  а так же, если на вызов метода equals() получаем true, то и hashCode() тоже должен быть у них един.
 * Хэш-таблицы реализованы в виде связанных списков, чтобы найти место объекта в таблице- вычисляется его хэш-код и
 * уменьшается его модуль до общего количества групп (если хэш-код объекта 76268 и групп 128, то он разместить в группе
 * 108 так как 76289 % 128 = 108). Если групп не хватает- создается новая хэш-таблица с большим числом групп, в которую
 * копируются элементы из старой таблица, копирование происходит при заполнении таблицы на 75%. Перебор коллекции
 * осуществляется Iterator.
 * <p>
 * Недостатком такой коллекции является то - что она не обеспечивает контроля над порядком расположения элементов.
 * <p>
 * HashSet следует пользоваться тогда, когда нам важно, чтобы не было одинаковых элементов в коллекции и нам не важно
 * расположение элементов в коллекции.
 *
 * @author Ross Khapilov
 * @version 1.0 created on 22.12.2017
 */
public class HashSetTest {
    public static void main(String[] args) throws FileNotFoundException {
        //объет типа HashSet, реализующий хэш-множество
        Set<String> words = new HashSet<>();

        long totalTime = 0;
        try (Scanner in = new Scanner(new File("src\\javaCore\\collections\\HashSetWarAndPeace.txt"))) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }

        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext(); i++) {
            System.out.println(iter.next());
        }
        System.out.println(". . .");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds");

    }
}
