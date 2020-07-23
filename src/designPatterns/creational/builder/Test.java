package designPatterns.creational.builder;

/**
 * Отделяет конструирование сложного объекта от его представления, так что
 * в результате одного и того же процесса конструирования могут получаться разные представления
 * <p>
 * Применимость
 * Используйте паттерн строитель, когда:
 * ❑ алгоритм создания сложного объекта не должен зависеть от того, из каких
 * частей состоит объект и как они стыкуются между собой;
 * ❑ процесс конструирования должен обеспечивать различные представления
 * конструируемого объекта.
 *
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
public class Test {
    public static void main(String[] args) {
        CarBuilder carBuilder = new SedanCarBuilder();
        CarDirector director = new CarDirector(carBuilder);
        director.build();
        Car car = carBuilder.getCar();
        System.out.println(car);

        System.out.println("*************************************");

        carBuilder = new SportsCarBuilder();
        director = new CarDirector(carBuilder);
        director.build();
        car = carBuilder.getCar();
        System.out.println(car);
    }
}
