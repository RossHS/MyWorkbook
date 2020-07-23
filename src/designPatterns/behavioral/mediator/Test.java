package designPatterns.behavioral.mediator;

/**
 * Посредник — это поведенческий паттерн проектирования, который позволяет уменьшить связанность
 * множества классов между собой, благодаря перемещению этих связей в один класс-посредник.
 * <p>
 * Когда вам сложно менять некоторые классы из-за того, что они имеют множество хаотичных связей с другими классами.
 * <p>
 * Посредник позволяет поместить все эти связи в один класс, после чего вам будет легче их отрефакторить,
 * сделать более понятными и гибкими.
 * <p>
 * Когда вы не можете повторно использовать класс, поскольку он зависит от уймы других классов.
 * <p>
 * После применения паттерна компоненты теряют прежние связи с другими компонентами,
 * а всё их общение происходит косвенно, через объект-посредник.
 * <p>
 * Когда вам приходится создавать множество подклассов компонентов,
 * чтобы использовать одни и те же компоненты в разных контекстах.
 * <p>
 * Если раньше изменение отношений в одном компоненте могли повлечь за собой лавину
 * изменений во всех остальных компонентах, то теперь вам достаточно создать
 * подкласс посредника и поменять в нём связи между компонентами.
 *
 * @author Ross Khapilov
 * @version 1.0 06.07.2019
 */
public class Test {
    public static void main(String[] args) {
        MachineMediator mediator;
        Sensor sensor = new Sensor();
        SoilRemoval soilRemoval = new SoilRemoval();
        Motor motor = new Motor();
        Machine machine = new Machine();
        Heater heater = new Heater();
        Valve valve = new Valve();
        Button button = new Button();

        mediator = new CottonMediator(machine, heater, motor, sensor, soilRemoval, valve);

        button.setMediator(mediator);
        machine.setMediator(mediator);
        heater.setMediator(mediator);
        valve.setMediator(mediator);
        button.press();


        mediator = new DenimMediator(machine, heater, motor, sensor, soilRemoval, valve);
        button.setMediator(mediator);
        machine.setMediator(mediator);
        heater.setMediator(mediator);
        valve.setMediator(mediator);
        button.press();
    }
}
