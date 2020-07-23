package designPatterns.structural.decorator;

/**
 * @author Ross Khapilov
 * @version 1.0 25.06.2019
 */
public class Broccoli extends PizzaDecorator {
    private final Pizza pizza;

    public Broccoli(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Broccoli (9.25)";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 9.25;
    }
}
