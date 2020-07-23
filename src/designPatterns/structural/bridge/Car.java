package designPatterns.structural.bridge;

/**
 * @author Ross Khapilov
 * @version 1.0 23.06.2019
 */
public abstract class Car {
    private final Product product;
    private final String carType;

    public Car(Product product, String carType) {
        this.product = product;
        this.carType = carType;
    }

    public abstract void assemble();

    public abstract void produceProduct();

    public void printDetails() {
        System.out.println("Car: " + carType + ", Product: " + product.productName());
    }
}
