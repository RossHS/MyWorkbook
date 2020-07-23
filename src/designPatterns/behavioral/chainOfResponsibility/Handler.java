package designPatterns.behavioral.chainOfResponsibility;

/**
 * @author Ross Khapilov
 * @version 1.0 27.06.2019
 */
public interface Handler {
    void setHandler(Handler handler);
    void process(File file);
    String getHandlerName();
}
