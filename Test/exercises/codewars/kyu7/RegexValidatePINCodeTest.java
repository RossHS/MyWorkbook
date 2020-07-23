package exercises.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ross Khapilov
 * @version 1.0 29.03.2019
 */
class RegexValidatePINCodeTest {
    @Test
    public void test() {
        assertTrue(RegexValidatePINCode.validatePin("1234"));
        assertFalse(RegexValidatePINCode.validatePin("12340"));
        assertFalse(RegexValidatePINCode.validatePin("-1234"));
        assertFalse(RegexValidatePINCode.validatePin("a234"));
        assertFalse(RegexValidatePINCode.validatePin("2.34"));
        assertFalse(RegexValidatePINCode.validatePin("234"));
    }
}