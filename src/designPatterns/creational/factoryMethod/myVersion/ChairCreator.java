package designPatterns.creational.factoryMethod.myVersion;

/**
 * @author Ross Khapilov
 * @version 1.0 20.07.2020
 */
public class ChairCreator implements Creator {
    @Override
    public Product createProduct() {
        return new ChairProduct();
    }
}
