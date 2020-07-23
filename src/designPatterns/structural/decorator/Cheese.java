package designPatterns.structural.decorator;

/**
 * @author Ross Khapilov
 * @version 1.0 26.06.2019
 */
public class Cheese extends PizzaDecorator {
    private final Pizza pizza;

    public Cheese(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese (20.72)";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 20.72;
    }
}
