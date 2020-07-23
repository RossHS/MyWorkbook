package exercises.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 20.04.2018
 */
class CheckThreeAndTwoTest {

    @Test
    public void testSomething() {
        assertTrue(new CheckThreeAndTwo().checkThreeAndTwo(new char[]{'a', 'a', 'b', 'b', 'b'}));
        assertFalse(new CheckThreeAndTwo().checkThreeAndTwo(new char[]{'a', 'c', 'a', 'c', 'b'}));
        assertFalse(new CheckThreeAndTwo().checkThreeAndTwo(new char[]{'a', 'a', 'a', 'a', 'a'}));
    }
    @Test
    public void testSomethingV2() {
        assertTrue(new CheckThreeAndTwo().checkThreeAndTwoV2(new char[]{'a', 'a', 'b', 'b', 'b'}));
        assertFalse(new CheckThreeAndTwo().checkThreeAndTwoV2(new char[]{'a', 'c', 'a', 'c', 'b'}));
        assertFalse(new CheckThreeAndTwo().checkThreeAndTwoV2(new char[]{'a', 'a', 'a', 'a', 'a'}));
    }
}