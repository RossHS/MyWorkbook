package designPatterns.creational.builder;

/**
 * ConcreteBuilder
 * • Constructs and assembles parts of the product by implementing the Builder interface.
 * • Defines and keeps track of the representation it creates.
 * • Provides an interface for retrieving the product.
 *
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
public class SedanCarBuilder implements CarBuilder {
    private final Car car = new Car("SEDAN");

    @Override
    public void buildBodyStyle() {
        car.setBodyStyle("External dimensions: overall length (inches): 202.9, " +
                "overall width (inches): 76.2, overall height (inches): 60.7, wheelbase (inches): 112.9, " +
                " front track (inches): 65.3, rear track (inches): 65.5 and curb to curb turning circle (feet): 39.5");
    }

    @Override
    public void buildPower() {
        car.setPower("323 hp @ 6,800 rpm; 278 ft lb of torque @ 4,800 rpm");
    }

    @Override
    public void buildEngine() {
        car.setEngine("3.6L V 6 DOHC and variable valve timing");
    }

    @Override
    public void buildBreaks() {
        car.setBreaks("Four-wheel disc brakes: two ventilated. Electronic brake distribution. StabiliTrak stability control");
    }

    @Override
    public void buildSeats() {
        car.setSeats("4 sport seats");
    }

    @Override
    public void buildWindows() {
        car.setWindows("Front windows with one-touch on two windows");
    }

    @Override
    public void buildFuelType() {
        car.setFuelType("Gasoline 17 MPG city, 28 MPG highway, 20 MPG combined and 380 mi. range");
    }

    @Override
    public Car getCar() {
        return car;
    }
}
