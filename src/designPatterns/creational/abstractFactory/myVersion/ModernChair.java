package designPatterns.creational.abstractFactory.myVersion;

/**
 * @author Ross Khapilov
 * @version 1.0 20.07.2020
 */
public class ModernChair implements AbstractChair {
    @Override
    public String getChairType() {
        return "Стул в стиле модерн";
    }
}
