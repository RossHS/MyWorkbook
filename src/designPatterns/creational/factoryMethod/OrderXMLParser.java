package designPatterns.creational.factoryMethod;

/**
 * @author Ross Khapilov
 * @version 1.0 21.06.2019
 */
public class OrderXMLParser implements XMLParser {
    @Override
    public String parse() {
        System.out.println("Parsing response XML...");
        return "Response XML message";
    }
}
