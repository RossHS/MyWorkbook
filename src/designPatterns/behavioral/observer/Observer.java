package designPatterns.behavioral.observer;

/**
 * @author Ross Khapilov
 * @version 1.0 27.06.2019
 */
public interface Observer {
    void update(String desc);

    void subscribe();

    void unsubcribe();
}
