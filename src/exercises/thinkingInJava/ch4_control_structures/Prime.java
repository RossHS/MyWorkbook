package thinkingInJava.ch4_control_structures;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 30.12.2017
 */
public class Prime {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int factor = 0;
            for (int j = 1; j <= i; j++) {
                if (i %j == 0) factor++;
            }
            if (factor == 2) System.out.print(i + ", ");
        }
    }
}
