package designPatterns.creational.factoryMethod.myVersion;

/**
 * @author Ross Khapilov
 * @version 1.0 20.07.2020
 */
public class Test {
    public static void main(String[] args) {
        Product product = new ChairCreator().createProduct();
        product.doStuff();

        product = new BedCreator().createProduct();
        product.doStuff();
    }
}
