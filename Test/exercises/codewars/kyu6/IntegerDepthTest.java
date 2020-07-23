package exercises.codewars.kyu6;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author Ross Khapilov
 * @version 1.0 07.09.2018
 */
class IntegerDepthTest {
    @Test
    public void sampleTest1() {
        Assert.assertEquals(10, new IntegerDepth().computeDepth(1));
    }

    @Test
    public void sampleTest2() {
        Assert.assertEquals(9, new IntegerDepth().computeDepth(42));
    }

}