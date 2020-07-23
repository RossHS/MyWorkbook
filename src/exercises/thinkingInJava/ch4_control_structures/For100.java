package thinkingInJava.ch4_control_structures;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 30.12.2017
 */
public class For100 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100 ; i++) {
            System.out.print(i + "\t ");
            if(i% 10 == 0) System.out.println();
        }
    }
}
