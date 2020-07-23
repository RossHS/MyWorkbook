package exercises.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ross Khapilov
 * @version 1.0 03.07.2018
 */
class CovfefeTest {
    @Test
    public void basicTest() {
        assertEquals("covfefe", Covfefe.covfefe("coverage"));
        assertEquals("covfefe covfefe", Covfefe.covfefe("coverage coverage"));
        assertEquals("nothing covfefe", Covfefe.covfefe("nothing"));
        assertEquals("double space  covfefe", Covfefe.covfefe("double space "));
        assertEquals("covfefe covfefe", Covfefe.covfefe("covfefe"));
    }
}