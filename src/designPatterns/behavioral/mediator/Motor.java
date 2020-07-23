package designPatterns.behavioral.mediator;

/**
 * @author Ross Khapilov
 * @version 1.0 06.07.2019
 */
public class Motor {

    public void startMotor() {
        System.out.println("Start motor...");
    }

    public void rotateDrum(int rpm) {
        System.out.println("Rotating drum at " + rpm + " rpm.");
    }
}
