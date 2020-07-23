package exercises.codewars.kyu4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ross Khapilov
 * @version 1.0 05.07.2018
 */
class NextBiggerNumberWithTheSameDigitsTest {
    @Test
    public void basicTests() {
        assertEquals(21, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(12));
        assertEquals(531, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(513));
        assertEquals(2071, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(2017));
        assertEquals(441, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(414));
        assertEquals(414, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(144));
    }
}