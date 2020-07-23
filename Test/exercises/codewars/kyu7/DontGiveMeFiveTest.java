package exercises.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
class DontGiveMeFiveTest {
    @Test
    public void exampleTests() {
        assertEquals(8, DontGiveMeFive.dontGiveMeFive(1,9));
        assertEquals(12, DontGiveMeFive.dontGiveMeFive(4,17));
    }
}