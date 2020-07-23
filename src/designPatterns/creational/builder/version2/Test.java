package designPatterns.creational.builder.version2;

import static designPatterns.creational.builder.version2.NyPizza.Size.SMALL;
import static designPatterns.creational.builder.version2.Pizza.Topping.ONION;
import static designPatterns.creational.builder.version2.Pizza.Topping.SAUSAGE;

/**
 * Версия из книги Блоха, Эффективная Java 3 редакция
 *
 * @author Ross Khapilov
 * @version 1.0 01.08.2019
 */
public class Test {
    public static void main(String[] args) {
        //т.е. у нас есть обязательные дав параметры, которые мы обязаны проинициализировать при создании объекта, и остальные по "желанию"
        NutritionFacts nf = new NutritionFacts.Builder(240, 8).setSodium(100).build();
        System.out.println(nf);

        NyPizza pizza = new NyPizza.Builder(SMALL).addTopping(SAUSAGE).addTopping(ONION).build();
        System.out.println(pizza);
    }
}
