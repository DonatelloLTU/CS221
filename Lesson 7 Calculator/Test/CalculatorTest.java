import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {
    Calculator calculator, calculator1, calculator2, calculator3;

    /**
     * Initializing statements for the test
     */
    @Before
    public void initialize()
    {
        calculator = new Calculator("(5+6)");
        calculator1 = new Calculator("(5+5)");
        calculator2 = new Calculator("((1+4)*2)");
        calculator3 = new Calculator("((1 + 3)/1");
    }

    /**
     * Test to get the post fix expression
     */
    @Test
    public void getPostfixTest()
    {
        assertEquals(calculator.getPostFix(), "56+");
        assertEquals(calculator1.getPostFix(), "55+");
        assertEquals(calculator2.getPostFix(), "14+2*");
        assertEquals(calculator3.getPostFix(),"13+1/");
    }


    /**
     * Test method to evaluate the postfix expression
     */
    @Test
    public void evaluate()
    {
        assertEquals(calculator.evaluate(), 11);
        assertEquals(calculator1.evaluate(), 10);
        assertEquals(calculator2.evaluate(), 10);
        assertEquals(calculator3.evaluate(), 4);
    }



}
