package exercises.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 18.01.2018
 */
class CountAllTheSheepTest {

    @Test
    void lostSheeps() {
        assertEquals(5, CountAllTheSheep.lostSheeps(new int[] {1,2}, new int[] {3,4}, 15));
        assertEquals(6, CountAllTheSheep.lostSheeps(new int[] {3,1,2}, new int[] {4,5}, 21));
    }
}