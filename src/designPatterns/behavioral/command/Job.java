package designPatterns.behavioral.command;

/**
 * We will implement the example using a command object. The command object will be referenced by a common interface and
 * will contain a method that will be used to execute the requests. The concrete command classes will override that method and will
 * provide their own specific implementation to execute the request.
 *
 * @author Ross Khapilov
 * @version 1.0 05.07.2019
 */
public interface Job {
    void run();
}
