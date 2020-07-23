package designPatterns.behavioral.mediator;

/**
 * @author Ross Khapilov
 * @version 1.0 06.07.2019
 */
public class Button implements Colleague {
    private MachineMediator mediator;

    @Override
    public void setMediator(MachineMediator mediator) {
        this.mediator = mediator;
    }

    public void press() {
        System.out.println("Button pressed");
        mediator.start();
    }
}
