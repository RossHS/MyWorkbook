package designPatterns.creational.abstractFactory;

/**
 * AbstractFactory
 * • Declares an interface for operations that create abstract product objects.
 *
 * @author Ross Khapilov
 * @version 1.0 21.06.2019
 */
public interface AbstractParserFactory {
    XMLParser getParserInstance(String parserType);
}
