package designPatterns.structural.decorator;

/**
 * @author Ross Khapilov
 * @version 1.0 26.06.2019
 */
public class Meat extends PizzaDecorator {
    private final Pizza pizza;

    public Meat(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Meat (14.25)";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 14.25;
    }
}
