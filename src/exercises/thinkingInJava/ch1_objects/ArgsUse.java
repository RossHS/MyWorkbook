package thinkingInJava.ch1_objects;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 18.12.2017
 */
public class ArgsUse {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg.toUpperCase());
        }
    }
}
