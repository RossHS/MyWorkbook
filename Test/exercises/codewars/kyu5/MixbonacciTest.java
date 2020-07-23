package exercises.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author Ross Khapilov
 * @version 1.0 29.09.2018
 */
class MixbonacciTest {
    @Test
    public void SampleTests() {
        TestData[] tests = new TestData[]{
                new TestData(new String[]{}, 0, new int[]{}),
                new TestData(new String[]{"fib"}, 0, new int[]{}),
                new TestData(new String[]{"fib"}, 10, new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}),
                new TestData(new String[]{"pad"}, 10, new int[]{1, 0, 0, 1, 0, 1, 1, 1, 2, 2}),
                new TestData(new String[]{"jac"}, 10, new int[]{0, 1, 1, 3, 5, 11, 21, 43, 85, 171}),
                new TestData(new String[]{"pel"}, 10, new int[]{0, 1, 2, 5, 12, 29, 70, 169, 408, 985}),
                new TestData(new String[]{"tri"}, 10, new int[]{0, 0, 1, 1, 2, 4, 7, 13, 24, 44}),
                new TestData(new String[]{"tet"}, 10, new int[]{0, 0, 0, 1, 1, 2, 4, 8, 15, 29}),
                new TestData(new String[]{"fib", "tet"}, 10, new int[]{0, 0, 1, 0, 1, 0, 2, 1, 3, 1}),
                new TestData(new String[]{"jac", "jac", "pel"}, 10, new int[]{0, 1, 0, 1, 3, 1, 5, 11, 2, 21})
        };

        for (TestData test : tests) {
            assertArrayEquals(test.getExpected(), Mixbonacci.mixbonacci(test.getPattern(), test.getLength()));
        }
    }

    public class TestData {
        private int length;
        private String[] pattern;
        private BigInteger[] expected;

        public TestData(String[] pattern, int length, int[] expected) {
            this.length = length;
            this.pattern = pattern;

            BigInteger[] exp = new BigInteger[expected.length];
            for (int i = 0; i < expected.length; i++) {
                exp[i] = BigInteger.valueOf(expected[i]);
            }

            this.expected = exp;
        }

        public String[] getPattern() {
            return pattern;
        }

        public int getLength() {
            return length;
        }

        public BigInteger[] getExpected() {
            return expected;
        }
    }
}