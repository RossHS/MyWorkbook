package exercises.codewars.kyu7;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

/**
 * @author Ross Khapilov
 * @version 1.0 23.09.2018
 */
class IsogramsTest {
    @Test
    public void FixedTests() {
        assertEquals(Isograms.isIsogram("Dermatoglyphics"), true);
        assertEquals(Isograms.isIsogram("isogram"), true);
        assertEquals(Isograms.isIsogram("moose"), false);
        assertEquals(Isograms.isIsogram("isIsogram"), false);
        assertEquals(Isograms.isIsogram("aba"), false);
        assertEquals(Isograms.isIsogram("moOse"), false);
        assertEquals(Isograms.isIsogram("thumbscrewjapingly"), true);
        assertEquals(Isograms.isIsogram(""), true);
    }
}