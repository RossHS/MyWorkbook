package designPatterns.creational.factoryMethod;

/**
 * ConcreteCreator
 * • Overrides the factory method to return an instance of a ConcreteProduct.
 *
 * @author Ross Khapilov
 * @version 1.0 21.06.2019
 */
public class OrderXMLDisplayService extends DisplayService {
    @Override
    protected XMLParser getParser() {
        return new OrderXMLParser();
    }
}
