package designPatterns.creational.abstractFactory;

/**
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
public class NYErrorXMLParser implements XMLParser {
    @Override
    public String parse() {
        System.out.println("NY Parsing error XML...");
        return "NY Error XML Message";
    }
}
