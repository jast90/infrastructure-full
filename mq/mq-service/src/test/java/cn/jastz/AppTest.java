package cn.jastz;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testIntegerCompare() {
        Integer a = 1;
        Integer b = 1;
        System.out.println(a == b ? a + "=" + b : a + "!=" + b);
        System.out.println(a.equals(b) ? a + " equals" + b : a + "not equals " + b);
        a = 190;
        b = 190;
        System.out.println(a.intValue() == b.intValue() ? a + ".intValue() =" + b + ".intValue()" : a + "!=" + b);
    }


    @Test
    public void incrementingValue() {
        int x = 5;
        x = x++;
        System.out.println(x);
    }
}
