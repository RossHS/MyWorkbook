package thinkingInJava.ch4_control_structures;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 30.12.2017
 */
public class Test {
    static int test(int testval, int begin, int end){
        if(begin > end) return -2;
        if(testval >= begin && testval <= end) return 1;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(test(4,1,4));
    }
}
