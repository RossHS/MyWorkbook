package designPatterns.creational.abstractFactory;

/**
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
public class ParserFactoryProducer {
    private ParserFactoryProducer() {
        throw new AssertionError();
    }

    public static AbstractParserFactory getFactory(String factoryType) {
        switch (factoryType) {
            case "NYFactory":
                return new NYParserFactory();
            case "TWFactory":
                return new TWParserFactory();
        }
        return null;
    }

}
