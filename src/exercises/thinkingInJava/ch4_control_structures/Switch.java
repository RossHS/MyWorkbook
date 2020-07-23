package thinkingInJava.ch4_control_structures;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 30.12.2017
 */
public class Switch {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    System.out.println("Ноль");
                    break;
                case 1:
                    System.out.println("Один");
                    break;
                case 2:
                    System.out.println("Два");
                case 3:
                    System.out.println("Три");
                    break;
                default:
                    System.out.println("ХЗ");
            }
            System.out.println();
        }
    }
}
