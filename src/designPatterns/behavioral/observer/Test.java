package designPatterns.behavioral.observer;

import java.util.ArrayList;

/**
 * Наблюдатель — это поведенческий паттерн проектирования, который создаёт механизм подписки,
 * позволяющий одним объектам следить и реагировать на события, происходящие в других объектах.
 * <p>
 * Когда после изменения состояния одного объекта требуется что-то сделать в других,
 * но вы не знаете наперёд, какие именно объекты должны отреагировать.
 * <p>
 * Описанная проблема может возникнуть при разработке библиотек пользовательского интерфейса,
 * когда вам надо дать возможность сторонним классам реагировать на клики по кнопкам.
 * <p>
 * Паттерн Наблюдатель позволяет любому объекту с интерфейсом подписчика зарегистрироваться
 * на получение оповещений о событиях, происходящих в объектах-издателях.
 * <p>
 * Когда одни объекты должны наблюдать за другими, но только в определённых случаях.
 * <p>
 * Издатели ведут динамические списки. Все наблюдатели могут подписываться или
 * отписываться от получения оповещений прямо во время выполнения программы.
 *
 * @author Ross Khapilov
 * @version 1.0 27.06.2019
 */
public class Test {
    public static void main(String[] args) {
        Subject subject = new CommentaryObject(new ArrayList<Observer>(), "Soccer Match [2014AUG24]");

        Observer observer = new SMSUsers(subject, "Adam Warner [New York]");
        observer.subscribe();
        System.out.println();

        Observer observer2 = new SMSUsers(subject, "Tim Ronney [London]");
        observer2.subscribe();
        System.out.println();

        Commentary cObject = (Commentary) subject;
        cObject.setDesc("Welcome to live Soccer match");
        cObject.setDesc("Current score 0-0");
        System.out.println();

        observer2.unsubcribe();

        System.out.println();
        cObject.setDesc("It’s a goal!!");
        cObject.setDesc("Current score 1-0");
        System.out.println();

        Observer observer3 = new SMSUsers(subject, "Marrie [Paris]");
        observer3.subscribe();
        System.out.println();

        cObject.setDesc("It’s another goal!!");
        cObject.setDesc("Half-time score 2-0");

    }
}
