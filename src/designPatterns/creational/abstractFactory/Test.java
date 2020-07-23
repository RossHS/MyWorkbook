package designPatterns.creational.abstractFactory;

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
 * @version 1.0 21.06.2019
 */
public class Test {
    public static void main(String[] args) {
        AbstractParserFactory parserFactory = ParserFactoryProducer.getFactory("NYFactory");
        XMLParser parser = parserFactory.getParserInstance("NYORDER");
        String msg = "";
        msg = parser.parse();
        System.out.println(msg);

        System.out.println("------------------------------------------");

        parserFactory = ParserFactoryProducer.getFactory("TWFactory");
        parser = parserFactory.getParserInstance("TWFEEDBACK");
        msg = parser.parse();
        System.out.println(msg);
    }
}
