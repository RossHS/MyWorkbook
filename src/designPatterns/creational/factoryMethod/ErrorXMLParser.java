package designPatterns.creational.factoryMethod;

/**
 * ConcreteProduct – конкретный продукт:
 * – реализует интерфейс XMLParser;
 *
 * @author Ross Khapilov
 * @version 1.0 21.06.2019
 */
public class ErrorXMLParser implements XMLParser {
    @Override
    public String parse() {
        System.out.println("Parsing error XML...");
        return "Error XML Message";
    }
}
