/**
 * PrefixExpressionADT is an interface for our PrefixExpression class
 * @author Donatas Vasauskas
 * @version 2020-10-06
 */
public interface PrefixExpressionADT
{

    /**
     * isPrefix method to check if the value PrefixExpression or not
     * @return true or false boolean depending on the expression
     */
    public boolean isPrefix();

    /**
     * calculate method uses calculations to calculate the prefixExpression
     * @return double number which is value after calculations
     */
    public double calculate();
}
