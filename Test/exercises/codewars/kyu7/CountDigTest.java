package exercises.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ross Khapilov
 * @version 1.0 24.03.2019
 */
class CountDigTest {
    @Test
    public  void test() {
        System.out.println("Start test");
        assertEquals(CountDig.nbDig(5750, 0), 4700);
        assertEquals(CountDig.nbDig(11011, 2), 9481);
        assertEquals(CountDig.nbDig(12224, 8), 7733);
        assertEquals(CountDig.nbDig(11549, 1), 11905);
    }
}