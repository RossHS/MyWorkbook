package designPatterns.creational.abstractFactory;

/**
 * ConcreteFactory
 * • Implements the operations to create concrete product objects.
 *
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
public class TWParserFactory implements AbstractParserFactory {
    @Override
    public XMLParser getParserInstance(String parserType) {
        switch (parserType) {
            case "TWERROR":
                return new TWErrorXMLParser();
            case "TWFEEDBACK":
                return new TWFeedbackXMLParser();
            case "TWORDER":
                return new TWOrderXMLParser();
        }
        return null;
    }
}
