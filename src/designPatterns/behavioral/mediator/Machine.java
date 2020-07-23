package designPatterns.behavioral.mediator;

/**
 * @author Ross Khapilov
 * @version 1.0 06.07.2019
 */
public class Machine implements Colleague {
    private MachineMediator mediator;

    @Override
    public void setMediator(MachineMediator mediator) {
        this.mediator = mediator;
    }

    public void start() {
        mediator.open();
    }

    public void wash() {
        mediator.wash();
    }
}
