import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {
    Calculator calculator, calculator1, calculator2;
    @Before
    public void initialize()
    {
        calculator = new Calculator("(5+6)");
        calculator1 = new Calculator("(5+5)");
        calculator2 = new Calculator("((1+4)*2)");
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
    }


    /**
     * Test method to evaluete the postfix expression
     */
    @Test
    public void evaluate()
    {
        assertEquals(calculator.evaluate(), 11);
        assertEquals(calculator1.evaluate(), 10);
        assertEquals(calculator2.evaluate(), 10);
    }



}
