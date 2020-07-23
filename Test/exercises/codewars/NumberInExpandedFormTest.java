package exercises.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 18.01.2018
 */
class NumberInExpandedFormTest {
    @Test
    public void testSomething() {
        assertEquals("10 + 2", NumberInExpandedForm.expandedForm(12));
        assertEquals("40 + 2", NumberInExpandedForm.expandedForm(42));
        assertEquals("70000 + 300 + 4", NumberInExpandedForm.expandedForm(70304));
        assertEquals("90000", NumberInExpandedForm.expandedForm(90000));
    }

}