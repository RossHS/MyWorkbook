package designPatterns.structural.decorator;

/**
 * @author Ross Khapilov
 * @version 1.0 25.06.2019
 */
public class SimplyVegPizza implements Pizza {
    @Override
    public String getDescription() {
        return "SimplyVegPizza (230)";
    }

    @Override
    public double getPrice() {
        return 230;
    }
}
