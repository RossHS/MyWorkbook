package designPatterns.creational.builder;

/**
 * Director
 * • Constructs an object using the Builder interface.
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
public class CarDirector {
    private CarBuilder carBuilder;

    public CarDirector(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public void build() {
        carBuilder.buildBodyStyle();
        carBuilder.buildBreaks();
        carBuilder.buildEngine();
        carBuilder.buildFuelType();
        carBuilder.buildPower();
        carBuilder.buildSeats();
        carBuilder.buildWindows();
    }
}
