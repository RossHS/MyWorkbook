package exercises.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 25.04.2018
 */
class UniqueNumberTest {
    private double precision = 0.0000000000001;
    @Test
    public void sampleTestCases() {
        assertEquals(1.0, UniqueNumber.findUniq(new double[]{0, 1, 0}), precision);
        assertEquals(2.0, UniqueNumber.findUniq(new double[]{1, 1, 1, 2, 1, 1}), precision);
    }
}