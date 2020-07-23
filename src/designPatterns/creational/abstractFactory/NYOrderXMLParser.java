package designPatterns.creational.abstractFactory;

/**
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
public class NYOrderXMLParser implements XMLParser {
    @Override
    public String parse() {
        System.out.println("NY Parsing order XML...");
        return "NY Order XML Message";
    }
}
