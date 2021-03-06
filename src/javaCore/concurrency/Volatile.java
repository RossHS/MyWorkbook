package javaCore.concurrency;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Ключевое слово volatile обозначает неблокирующий механизм синхронизированного
 * доступа к полю экземпляра. Если поле объявляется как volatile, то компилятор
 * и виртуальная машина принимают во внимание тот факт, что поле может
 * быть параллельно обновлено в другом потоке исполнения.
 * Допустим, у объекта имеется поле признака done типа boolean, который устанавливается
 * в одном потоке исполнения и опрашивается в другом. Как пояснялось ранее,
 * для этой цели можно организовать встроенную блокировку следующим образом:
 * private boolean done;
 * public s y n c h ro n iz e d boolean isDoneO { return done; }
 * public s y n c h ro n iz e d void setDoneO { done = true; }
 * Применять встроенную блокировку объекта — вероятно, не самая лучшая идея.
 * Ведь методы isDone () и setDone () могут блокироваться, если другой поток исполнения
 * заблокировал объект. В таком случае можно воспользоваться отдельным объектом
 * типа Lock только для данной переменной. Но это повлечет за собой немало
 * хлопот. Поэтому в данном случае имеет смысл объявить поле как volatile следующим
 * образом:
 * private v o l a t i l e boolean done;
 * public boolean isDoneO { return done; }
 * public void setDoneO { done = true; }
 * <p>
 * Вкратце, определение переменной с ключевым словом volatile означает, что значение этой переменной может изменяться
 * другими потоками. Чтобы как следует понять, что делает ключевое слово volatile, полезно разобраться, как потоки
 * обрабатывают обычные переменные.
 * <p>
 * В целях повышения производительности спецификация языка Java допускает сохранение в JRE локальной копии переменной
 * для каждого потока, который на нее ссылается. Такие «локальные» копии переменных напоминают кэш и помогают потоку
 * избежать обращения к главной памяти каждый раз, когда требуется получить значение переменной.
 * <p>
 * Но давайте посмотрим, что происходит в следующем сценарии: запускаются два потока, и один из них считывает
 * переменную A как 5, а второй ― как 10. Если значение переменной А изменилось с 5 на 10, то первый поток не
 * узнает об изменении и будет хранить неправильное значение A. Однако если переменная А помечена как volatile,
 * то когда бы поток не считывал значение A, он будет обращаться к главной копии A и считывать ее текущее значение.
 * <p>
 * Локальный кэш потока имеет смысл в том случае, если переменные в ваших приложениях не будут изменяться извне.
 * Если это не так, то знать, что делает ключевое слово volatile, очень полезно.
 *
 * @author Ross Khapilov
 * @version 1.0 10.09.2018
 */
public class Volatile {
    int a = 10;
    int b = 10;
    int c = a + b;

    public static void main(String[] args) {
        Volatile s = new Volatile();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep((long) (Math.random() * 100));
                        s.count((int) (Math.random() * 10));
                        System.out.println(Thread.currentThread() + "  c=" + s.c);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    /**
     * Небезопасно, тк изменяем ресурсы из разных поток
     *
     * @param n
     */
    private void count(int n) {
        a -= n;
        b += n;
        c = a + b;
    }
}
