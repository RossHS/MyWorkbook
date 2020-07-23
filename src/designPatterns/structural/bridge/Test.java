package designPatterns.structural.bridge;

/**
 * Мост — это структурный паттерн проектирования, который разделяет один или несколько классов на две отдельные
 * иерархии — абстракцию и реализацию, позволяя изменять их независимо друг от друга.
 * <p>
 * Применимость
 * Используйте паттерн мост, когда:
 * ❑ хотите избежать постоянной привязки абстракции к реализации. Так, на
 * пример, бывает, когда реализацию необходимо выбирать во время выполне
 * ния программы;
 * ❑ и абстракции, и реализации должны расширяться новыми подклассами.
 * В таком случае паттерн мост позволяет комбинировать разные абстрак
 * ции и реализации и изменять их независимо;
 * ❑ изменения в реализации абстракции не должны сказываться на клиентах,
 * то есть клиентский код не должен перекомпилироваться;
 *
 * @author Ross Khapilov
 * @version 1.0 23.06.2019
 */
public class Test {
    public static void main(String[] args) {
        Product product1 = new CentralLocking("Central Locking System");
        Product product2 = new GearLocking("Gear Locking System");
        Car car = new BigWheel(product1,"BigWheel xz model");
        car.produceProduct();
        car.assemble();
        car.printDetails();

        System.out.println();

        car = new BigWheel(product2, "BigWheel xz model");
        car.produceProduct();
        car.assemble();
        car.printDetails();

        System.out.println();

        car = new Motoren(product1,"Motoren model");
        car.produceProduct();
        car.assemble();
        car.printDetails();
    }
}
