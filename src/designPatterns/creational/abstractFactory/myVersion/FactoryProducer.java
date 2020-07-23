package designPatterns.creational.abstractFactory.myVersion;

/**
 * Вспомогательный класс для получения различных фабрик
 *
 * @author Ross Khapilov
 * @version 1.0 20.07.2020
 */
public class FactoryProducer {
    public enum FactoryType {VICTORIAN, MODERN}

    public static AbstractFactory getAbstractFactory(FactoryType type) {
        switch (type) {
            case MODERN:
                return new ModernFactory();
            case VICTORIAN:
                return new VictorianFactory();
            default:
                return null;
        }
    }
}
