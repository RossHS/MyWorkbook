package designPatterns.creational.factoryMethod;

/**
 * • Declares the factory method, which returns an object of type Product. Creator may also define a default implementation of the
 * factory method that returns a default ConcreteProduct object.
 * • May call the factory method to create a Product object.
 *
 * @author Ross Khapilov
 * @version 1.0 21.06.2019
 */
public abstract class DisplayService {
    public void display() {
        XMLParser parser = getParser();
        String message = parser.parse();
        System.out.println(message);
    }

    protected abstract XMLParser getParser();
}
