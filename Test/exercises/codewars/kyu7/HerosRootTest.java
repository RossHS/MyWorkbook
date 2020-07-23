package exercises.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 10.05.2018
 */
class HerosRootTest {

    @Test
    public void test0() {
        System.out.println("Fixed Tests");
        assertEquals(4, HerosRoot.IntRac(25, 1));
        assertEquals(4, HerosRoot.IntRac(125348, 300), 3);
    }
}