package designPatterns.behavioral.mediator;

/**
 * @author Ross Khapilov
 * @version 1.0 06.07.2019
 */
public class Sensor {
    public boolean checkTemperature(int temp) {
        System.out.println("Temperature reached " + temp + " *C");
        return true;
    }
}
