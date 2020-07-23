package exercises.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ross Khapilov
 * @version 1.0 18.04.2019
 */
class TriangleTesterTest {
    @Test
    public void publicTests() {
        assertEquals(false, TriangleTester.isTriangle(7,2,2));
        assertEquals(true, TriangleTester.isTriangle(1,2,2));
        assertEquals(false, TriangleTester.isTriangle(0,3,2));
        assertEquals(false, TriangleTester.isTriangle(-7,2,2));
    }
}