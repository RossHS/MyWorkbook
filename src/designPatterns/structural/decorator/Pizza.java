package designPatterns.structural.decorator;

/**
 * Component
 * • Defines the interface for objects that can have responsibilities added to them dynamically.
 *
 * @author Ross Khapilov
 * @version 1.0 25.06.2019
 */
public interface Pizza {
    String getDescription();

    double getPrice();
}
