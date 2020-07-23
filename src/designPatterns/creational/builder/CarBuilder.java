package designPatterns.creational.builder;

/**
 * Builder
 * • Specifies an abstract interface for creating parts of a Product object.
 *
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
public interface CarBuilder {
    void buildBodyStyle();

    void buildPower();

    void buildEngine();

    void buildBreaks();

    void buildSeats();

    void buildWindows();

    void buildFuelType();

    Car getCar();
}
