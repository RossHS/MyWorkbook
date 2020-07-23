package designPatterns.creational.abstractFactory.myVersion;

/**
 * @author Ross Khapilov
 * @version 1.0 20.07.2020
 */
public class ModernBed implements AbstractBed {
    @Override
    public String getBedType() {
        return "Кровать в стиле модерн";
    }
}
