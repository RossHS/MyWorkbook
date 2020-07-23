package exercises.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 21.12.2017
 */
class SequenceSumTest {

    @Test
    void showSequence() {
        assertEquals("0+1+2+3+4+5+6 = 21",SequenceSum.showSequence(6));
    }
}