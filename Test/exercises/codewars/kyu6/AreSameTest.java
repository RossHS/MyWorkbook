package exercises.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ross Khapilov
 * @version 1.0 19.04.2019
 */
class AreSameTest {

    @Test
    void test1() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertTrue(AreSame.comp(a, b));
    }

    @Test
    void test2() {
        int[] a = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = {121, 14641, 20736, 36100, 25921, 361, 20736, 361};
        assertFalse(AreSame.comp(a, b));
    }

    @Test
    void test3() {
        int[] a = {11, 12};
        int[] b = {121};
        assertFalse(AreSame.comp(a, b));
    }

    @Test
    void test4() {
        int[] a = new int[]{0, -14, 191, 161, 19, 144, 195, 1};
        int[] b = new int[]{1, 0, 196, 36481, 25921, 361, 20736, 38025};
        assertTrue(AreSame.comp(a, b));
    }
}