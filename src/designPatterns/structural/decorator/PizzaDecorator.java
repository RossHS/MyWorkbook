package designPatterns.structural.decorator;

/**
 * @author Ross Khapilov
 * @version 1.0 25.06.2019
 */
public abstract class PizzaDecorator implements Pizza {
    @Override
    public String getDescription() {
        return "Toppings";
    }
}
