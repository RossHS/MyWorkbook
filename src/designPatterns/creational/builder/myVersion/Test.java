package designPatterns.creational.builder.myVersion;

/**
 * @author Ross Khapilov
 * @version 1.0 20.07.2020
 */
public class Test {
    public static void main(String[] args) {
        Chair c = new Chair.Builder().setHeight(100).setHeight(100).build();
        System.out.println(c);
    }
}
