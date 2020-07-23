package designPatterns.creational.abstractFactory.myVersion;

/**
 * @author Ross Khapilov
 * @version 1.0 20.07.2020
 */
public class VictorianFactory implements AbstractFactory {
    @Override
    public AbstractChair createChair() {
        System.out.println("Создан стул в стиле модерн");
        return new VictorianChair();
    }

    @Override
    public AbstractBed createBed() {
        System.out.println("Создана кровать в стиле модерн");
        return new VictorianBed();
    }
}