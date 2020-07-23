package javaCore.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * LinkedList это обычный связанный список, состоящий из узлов. В каждом узле, хранится ссылки на
 * следующий/предыдующий узел и значение. В самом списке, есть ссылки на последний и первый узел, а так же размер.
 * В LinkedList вставка осуществляется так: находится элемент, за которым должен следовать вставляемый элемент,
 * изменяются ссылки в нем и следующим за ним. В LinkedList чтобы найти элемент с нужным индексом,
 * нужно пройтись поочередно по ссылкам от первого элемента и до последнего (в худшем случае).
 * В ArrayList получения элемента происходит простым взятием по индексу из массива.
 * За этот метод add (), зависящий от расположения элементов в связном списке, отвечает
 * итератор, поскольку в итераторе описывается расположение элементов в коллекции.
 * Применение итераторов для ввода элементов имеет смысл только для коллекций,
 * имеющих естественный порядок расположения.
 * <p>
 * Стоит выбирать LinkedList в случае, если происходит постоянное добавление и удаление элементов в коллекцию
 *
 * @author Ross Khapilov
 * @version 1.0 created on 18.12.2017
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        //Объединение двух списков
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        //Удалить каждое второе слово из связанного списка b
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);

        //Удаляем из списка a все составляющие списка b
        a.removeAll(b);
        System.out.println(a);
    }
}
