package designPatterns.structural.bridge;

/**
 * @author Ross Khapilov
 * @version 1.0 23.06.2019
 */
public class GearLocking implements Product {
    private final String productName;

    public GearLocking(String productName) {
        this.productName = productName;
    }

    @Override
    public String productName() {
        return productName;
    }

    @Override
    public void produce() {
        System.out.println("Producing Gear Locking System");
    }
}
