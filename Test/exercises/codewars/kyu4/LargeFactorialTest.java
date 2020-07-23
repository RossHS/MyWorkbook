package exercises.codewars.kyu4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ross Khapilov
 * @version 1.0 16.06.2018
 */
class LargeFactorialTest {
    @Test
    public void BasicTests() {
        assertEquals("1", LargeFactorial.Factorial(1));
        assertEquals("120", LargeFactorial.Factorial(5));
        assertEquals("362880", LargeFactorial.Factorial(9));
        assertEquals("1307674368000", LargeFactorial.Factorial(15));
    }
}