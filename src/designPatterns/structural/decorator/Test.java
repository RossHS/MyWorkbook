package designPatterns.structural.decorator;

import java.text.DecimalFormat;

/**
 * Декоратор — это структурный паттерн проектирования, который позволяет динамически
 * добавлять объектам новую функциональность, оборачивая их в полезные «обёртки».
 * <p>
 * Когда вам нужно добавлять обязанности объектам на лету, незаметно для кода, который их использует.
 * <p>
 * Объекты помещают в обёртки, имеющие дополнительные поведения. Обёртки и сами объекты имеют одинаковый
 * интерфейс, поэтому клиентам без разницы, с чем работать — с обычным объектом данных или с обёрнутым.
 * <p>
 * Когда нельзя расширить обязанности объекта с помощью наследования.
 * <p>
 * Во многих языках программирования есть ключевое слово final, которое может заблокировать наследование
 * класса. Расширить такие классы можно только с помощью Декоратора.
 *
 * @author Ross Khapilov
 * @version 1.0 25.06.2019
 */
public class Test {
    public static void main(String[] args) {
        DecimalFormat dFormat = new DecimalFormat("#.##");
        Pizza pizza = new SimplyVegPizza();

        pizza = new Meat(pizza);
        pizza = new Cheese(pizza);
        pizza = new Broccoli(pizza);

        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Price: " + dFormat.format(pizza.getPrice()));

        pizza = new SimplyNonVegPizza();

        pizza = new Cheese(pizza);
        pizza = new Cheese(pizza);

        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Price: " + dFormat.format(pizza.getPrice()));


    }
}
