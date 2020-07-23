package designPatterns.behavioral.mediator;

/**
 * @author Ross Khapilov
 * @version 1.0 06.07.2019
 */
public interface MachineMediator {
    void start();

    void wash();

    void open();

    void closed();

    void on();

    void off();

    boolean checkTemperature(int temp);
}
