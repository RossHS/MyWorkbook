package exercises.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ross Khapilov
 * @version 1.0 05.05.2019
 */
class ASumTest {
    @Test
    public void test1() {
        assertEquals(2022, ASum.findNb(4183059834009L));
    }

    @Test
    public void test2() {
        assertEquals(-1, ASum.findNb(24723578342962L));
    }

    @Test
    public void test3() {
        assertEquals(4824, ASum.findNb(135440716410000L));
    }

    @Test
    public void test4() {
        assertEquals(3568, ASum.findNb(40539911473216L));
    }

    @Test
    public void test5() {
        assertEquals(45, ASum.findNb(1071225));
    }

    @Test
    public void test6() {
        assertEquals(55100, ASum.findNb(2304422822859502500L));
    }

    @Test
    public void test7() {
        assertEquals(52075, ASum.findNb(1838543046262322500L));
    }
}