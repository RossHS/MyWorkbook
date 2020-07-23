package designPatterns.structural.bridge;

/**
 * @author Ross Khapilov
 * @version 1.0 23.06.2019
 */
public class BigWheel extends Car {
    private final Product product;
    private final String carType;

    public BigWheel(Product product, String carType) {
        super(product, carType);
        this.product = product;
        this.carType = carType;
    }

    @Override
    public void assemble() {
        System.out.println("Assembling " + product.productName() + " for " + carType);
    }

    @Override
    public void produceProduct() {
        product.produce();
        System.out.println("Modifing product " + product.productName() + " according to " + carType);
    }
}
