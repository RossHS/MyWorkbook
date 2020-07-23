package thinkingInJava.ch1_objects;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 18.12.2017
 */
public class Autoboxing {
    public static void main(String[] args) {
        Integer integer = Integer.valueOf(15);
        int num = integer.intValue();
        //или с автоупаковкой/распаковкой
        Integer integer1 = 14;
        int num1 = integer1;
    }
}
