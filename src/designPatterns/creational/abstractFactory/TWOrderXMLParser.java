package designPatterns.creational.abstractFactory;

/**
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
public class TWOrderXMLParser implements XMLParser {
    @Override
    public String parse() {
        System.out.println("TW Parsing order XML...");
        return "TW Order XML Message";
    }
}
