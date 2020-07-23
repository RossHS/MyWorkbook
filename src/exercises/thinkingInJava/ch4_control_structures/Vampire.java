package thinkingInJava.ch4_control_structures;

import java.util.Arrays;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 06.01.2018
 */
public class Vampire {
    public static void main(String[] args) {
        for (int i = 1000; i < 10_000; i++) {
            int[] nums = new int[4];
            int temp = i;
            for (int j = nums.length - 1; j >= 0; j--) {
                nums[j] = temp % 10;
                temp /= 10;
            }
            System.out.println(Arrays.toString(nums));
        }
    }
}
