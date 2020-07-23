package designPatterns.creational.abstractFactory.myVersion;

/**
 * Абстрактная фабрика – паттерн, порождающий объекты.
 * <p>
 * Назначение
 * <p>
 * Предоставляет интерфейс для создания семейств взаимосвязанных или взаи
 * мозависимых объектов, не специфицируя их конкретных классов.
 * <p>
 * Применимость
 * Используйте паттерн абстрактная фабрика, когда:
 * ❑ система не должна зависеть от того, как создаются, компонуются и пред
 * ставляются входящие в нее объекты;
 * ❑ входящие в семейство взаимосвязанные объекты должны использоваться
 * вместе и вам необходимо обеспечить выполнение этого ограничения;
 * ❑ система должна конфигурироваться одним из семейств составляющих ее
 * объектов;
 * ❑ вы хотите предоставить библиотеку объектов, раскрывая только их интер
 * фейсы, но не реализацию.
 *
 * @author Ross Khapilov
 * @version 1.0 20.07.2020
 */
public class Test {
    public static void main(String[] args) {
        AbstractFactory factory = FactoryProducer.getAbstractFactory(FactoryProducer.FactoryType.MODERN);
        AbstractBed bed = factory.createBed();
        AbstractChair chair = factory.createChair();
        printBedChair(bed, chair);
        System.out.println("-------------------------------");

        factory = FactoryProducer.getAbstractFactory(FactoryProducer.FactoryType.VICTORIAN);
        bed = factory.createBed();
        chair = factory.createChair();
        printBedChair(bed, chair);
    }

    private static void printBedChair(AbstractBed bed, AbstractChair chair) {
        System.out.println("Стиль кровати: " + bed.getBedType() + "; Стиль стула: " + chair.getChairType());
    }
}
