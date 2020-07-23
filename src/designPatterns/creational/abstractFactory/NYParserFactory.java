package designPatterns.creational.abstractFactory;

/**
 * ConcreteFactory
 * • Implements the operations to create concrete product objects.
 *
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
public class NYParserFactory implements AbstractParserFactory {
    @Override
    public XMLParser getParserInstance(String parserType) {
        switch (parserType) {
            case "NYERROR":
                return new NYErrorXMLParser();
            case "NYFEEDBACK":
                return new NYFeedbackXMLParser();
            case "NYORDER":
                return new NYOrderXMLParser();
        }
        return null;
    }
}
