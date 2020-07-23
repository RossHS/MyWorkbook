package designPatterns.creational.prototype;

/**
 * Prototype
 * • Declares an interface for cloning itself.
 *
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
public interface Prototype extends Cloneable {
    AccessControl clone() throws CloneNotSupportedException;
}
