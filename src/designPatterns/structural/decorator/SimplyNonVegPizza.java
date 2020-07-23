package designPatterns.structural.decorator;

/**
 * @author Ross Khapilov
 * @version 1.0 25.06.2019
 */
public class SimplyNonVegPizza implements Pizza {

    @Override
    public String getDescription() {
        return "SimplyNonVegPizza (350)";
    }

    @Override
    public double getPrice() {
        return 350;
    }
}
