package exercises.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 21.12.2017
 */
class CountPositivesSumNegativesTest {

    @Test
    void countPositivesSumNegatives() {
        int[] expectedResult = new int[]{10, -65};
        assertArrayEquals(expectedResult, CountPositivesSumNegatives.
                countPositivesSumNegatives(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}));

    }

    @Test
    void countPositivesSumNegatives_InputWithZeroes() {
        int[] expectedResult = new int[]{8, -50};
        assertArrayEquals(expectedResult, CountPositivesSumNegatives.
                countPositivesSumNegatives(new int[]{0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}));
    }
}