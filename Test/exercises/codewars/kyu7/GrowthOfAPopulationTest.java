package exercises.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ross Khapilov
 * @version 1.0 03.11.2018
 */
class GrowthOfAPopulationTest {

    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        System.out.println("Fixed Tests: nbYear");
        testing(GrowthOfAPopulation.nbYear(1500, 5, 100, 5000), 15);
        testing(GrowthOfAPopulation.nbYear(1500000, 2.5, 10000, 2000000), 10);
        testing(GrowthOfAPopulation.nbYear(1500000, 0.25, 1000, 2000000), 94);
    }
}