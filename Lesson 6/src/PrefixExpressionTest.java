import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.util.prefs.Preferences;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PrefixPrefixExpressionTest is a class to test all the methods for the PrefixExpression class
 * @author Donatas Vasauskas
 * @version 2020-10-06.01
 */
public class PrefixExpressionTest
{
    String a,b,c,d,e,f,g,h;
    PrefixExpression a1, b1, c1, d1, e1, f1, g1, h1;

    /**
     * before method to set up conditions for our test
     */
    @Before
    public void before()
    {
        a = "+ab";
        a1 = new PrefixExpression(a);
        b = "ab+";
        b1 = new PrefixExpression(b);
        c = "-ab";
        c1 = new PrefixExpression(c);
        d = "ab-";
        d1 = new PrefixExpression(d);
        e = "*ab";
        e1 = new PrefixExpression(e);
        f = "ab*";
        f1 = new PrefixExpression(f);
        g = "/ab";
        g1 = new PrefixExpression(g);
        h = "ab/";
        h1 = new PrefixExpression(h);

    }

    /**
     * after method makes all the values set in before method to null
     */
    @After
    public void after()
    {
        a = null;
        a1 = null;
        b = null;
        b1 = null;
        c = null;
        c1 = null;
        d = null;
        d1 = null;
        e = null;
        e1 = null;
        f = null;
        f1 = null;
        g = null;
        g1 = null;
        h = null;
        h1 = null;
    }

    /**
     * isPrefixTest checks if the method of isPrefix is working how intended
     */
    @Test
    public void isPrefixTest()
    {

        assertTrue(a1.isPrefix());
        assertFalse(b1.isPrefix());
        assertTrue(c1.isPrefix());
        assertFalse(d1.isPrefix());
        assertTrue(e1.isPrefix());
        assertFalse(f1.isPrefix());
        assertTrue(g1.isPrefix());
        assertFalse(h1.isPrefix());

    }

    /**
     * calculateTest checks if the methods of calculate evaluates prefixExpression properly
     */
    @Test
    public void calculate()
    {
        assertEquals(0.0, b1.calculate());
        assertEquals(0.0, d1.calculate());
        assertEquals(0.0, f1.calculate());
        assertEquals(0.0, h1.calculate());
    }
}
