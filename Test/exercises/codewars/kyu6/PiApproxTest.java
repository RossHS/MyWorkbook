package exercises.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ross Khapilov
 * @version 1.0 25.01.2019
 */
class PiApproxTest {
    @Test
    public void test1() {
        String res1 = "[10, 3.0418396189]";
        String res2 = PiApprox.iterPi2String(0.1);
        assertEquals(res1, res2);
    }
}