package designPatterns.creational.abstractFactory;

/**
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
public class TWErrorXMLParser implements XMLParser {
    @Override
    public String parse() {
        System.out.println("TW Parsing error XML...");
        return "TW Error XML Message";
    }
}
