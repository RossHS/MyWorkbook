package exercises.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ross Khapilov
 * @version 1.0 10.05.2019
 */
class ConversionTest {
    private Conversion conversion = new Conversion();

    @Test
    public void shouldConvertToRoman() {
        assertEquals( "I", conversion.solution(1));
        assertEquals("IV", conversion.solution(4));
        assertEquals("VI", conversion.solution(6));
    }

}