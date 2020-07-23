package designPatterns.creational.factoryMethod.myVersion;

/**
 * @author Ross Khapilov
 * @version 1.0 20.07.2020
 */
public class BedProduct implements Product {
    @Override
    public void doStuff() {
        System.out.println("Создали кровать");
    }
}
