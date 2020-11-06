
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;
import static sun.awt.FontConfiguration.verbose;


/**
 * PalindromTest class to test Palindrome class
 * @author Donatas Vasauskas
 * @version 2020-11-05.01
 */
public class PalindromeTest {

    Palindrome pal, pal1, pal2;
    @Before
    public void before()
    {
        pal = new Palindrome("kayak");
        pal1 = new Palindrome("90109");
        pal2 = new Palindrome("kayim");
    }

    @After
    public void after()
    {
        pal = null;
        pal1 = null;
        pal2 = null;

    }

    /**
     * Test method to check if the isPalendrome method works
     */
    @Test
    public void isPalendromeTest()
    {
        if (verbose) System.out.println("Testing Palendrome");
        System.out.println("First String is: " + pal.getString());
        assertTrue(pal.isPalindrome());
        System.out.println(pal.getString() + " is palendrome: "  + pal.isPalindrome());
        System.out.println("Second String is: " + pal1.getString());
        assertTrue(pal1.isPalindrome());
        System.out.println(pal1.getString() + " is palendrome: " + pal1.isPalindrome());
        System.out.println("Third String is: " + pal2.getString());
        assertFalse(pal2.isPalindrome());
        System.out.println(pal2.getString() + " is palendrome: " + pal2.isPalindrome());
    }
}
