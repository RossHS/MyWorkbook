package exercises.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ross Khapilov
 * @version 1.0 20.09.2018
 */
class ReducingByStepsTest {

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }
    @Test
    public void test0() {
        long[] a = new long[] { 18, 69, -90, -78, 65, 40 };

        long[] r = new long[] { 18, 3, 3, 3, 1, 1 };
        testing(Arrays.toString(ReducingBySteps.operArray(ReducingBySteps::gcdi, a, a[0])),
                Arrays.toString(r));
        r = new long[] { 18, 414, 2070, 26910, 26910, 107640 };
        testing(Arrays.toString(ReducingBySteps.operArray(ReducingBySteps::lcmu, a, a[0])),
                Arrays.toString(r));
        r = new long[] { 18, 87, -3, -81, -16, 24 };
        testing(Arrays.toString(ReducingBySteps.operArray(ReducingBySteps::som, a, 0)),
                Arrays.toString(r));
        r = new long[] { 18, 18, -90, -90, -90, -90 };
        testing(Arrays.toString(ReducingBySteps.operArray(ReducingBySteps::mini, a, a[0])),
                Arrays.toString(r));
        r = new long[] { 18, 69, 69, 69, 69, 69 };
        testing(Arrays.toString(ReducingBySteps.operArray(ReducingBySteps::maxi, a, a[0])),
                Arrays.toString(r));
    }
}