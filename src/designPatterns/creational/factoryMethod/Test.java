package designPatterns.creational.factoryMethod;

/**
 * Фабричный метод – паттерн, порождающий классы.
 * Назначение
 * Определяет интерфейс для создания объекта, но оставляет подклассам решение о том,
 * какой класс инстанцировать. Фабричный метод позволяет классу делегировать инстанцирование подклассам.
 * <p>
 * Применимость
 * Используйте паттерн фабричный метод, когда:
 * ❑ классу заранее неизвестно, объекты каких классов ему нужно создавать;
 * ❑ класс спроектирован так, чтобы объекты, которые он создает, специфицировались подклассами;
 * ❑ класс делегирует свои обязанности одному из нескольких вспомогательных
 * подклассов, и вы планируете локализовать знание о том, какой класс принимает
 * эти обязанности на себя.
 *
 * @author Ross Khapilov
 * @version 1.0 21.06.2019
 */
public class Test {
    public static void main(String[] args) {
        DisplayService service = new FeedbackXMLDisplayService();
        service.display();

        service = new ErrorXMLDisplayService();
        service.display();

        service = new OrderXMLDisplayService();
        service.display();
    }
}