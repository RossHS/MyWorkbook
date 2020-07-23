package exercises.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 30.03.2018
 */
class TwoToOneTest {

    @Test
    void longest() {
        System.out.println("longest Fixed Tests");
        assertEquals("aehrsty", TwoToOne.longest("aretheyhere", "yestheyarehere"));
        assertEquals("abcdefghilnoprstu", TwoToOne.longest("loopingisfunbutdangerous", "lessdangerousthancoding"));
        assertEquals("acefghilmnoprstuy", TwoToOne.longest("inmanylanguages", "theresapairoffunctions"));
    }
    @Test
    void longest1() {
        System.out.println("longest Fixed Tests");
        assertEquals(null, TwoToOne.longest("aretheyhere", "yestheyarehere"));
    }
}