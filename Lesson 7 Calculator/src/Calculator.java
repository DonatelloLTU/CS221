/**
 * Calculator converts and evaluates Infix to Postfix Expression and then calculates
 * @author Donatas Vasauskas
 * @version 2020-10-27.01
 */
public class Calculator {
    String infix;
    String postfix;

    /**
     * Constructor for calculator class
     * @param infix is infix expression
     */
    public Calculator(String infix)
    {
        this.infix=infix;
    }

    /**
     * Method to get infix expression
     * @return
     */
    public String toString()
    {
        return infix;
    }

    /**
     * Convert infix to postfix expression
     * @return true when expression is converted
     * @return false when expression is not converted
     */
    public boolean convertPost()
    {
        postfix = new String("");
        StackReferencedBased stack = new StackReferencedBased();
        infix = infix.replaceAll("\\s", ""); //bonus
        for(int i = 0; i < infix.length(); ++i)
        {
            char ch = infix.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                postfix += ch;
            }
            else if(ch == '(')
            {
                stack.push(ch);
            }
            else if(ch == ')')
            {
                while((char)stack.peek() != '(')
                {
                    if(!stack.isEmpty())
                    {
                        postfix += stack.pop();
                    }
                }
                stack.pop();
            }
            else
            {
                while((char)Precedence(ch) <= Precedence((char)stack.peek()))
                {
                    if(!stack.isEmpty())
                    {
                        postfix += stack.pop();
                    }
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty())
        {
            if((char)stack.peek() == '(' || stack.isEmpty())
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to get converted postfix expression
     * @return
     */
    public String getPostFix() throws IllegalStateException
    {
        if(convertPost() == true)
        {
            return postfix;
        }
        else
        {
            throw new IllegalStateException("Expression cannot be converted");
        }

    }

    /**
     * Method to evaluate the postfix expression
     * @return
     * @throws IllegalStateException
     */
    public int evaluate() throws IllegalStateException
    {
        getPostFix();
        StackReferencedBased stack = new StackReferencedBased();

        for(int i = 0; i < postfix.length(); i++)
        {
            char ch = postfix.charAt(i);
            if(Character.isDigit(ch))
            {
                stack.push(ch - '0');
            }
            else
            {
                int number = (Integer)stack.pop();
                int number1 = (Integer)stack.pop();
                switch(ch)
                {
                    case '+':
                        stack.push(number1+number);
                        break;
                    case '-':
                        stack.push(number1- number);
                        break;
                    case '/':
                        stack.push(number1/number);
                        break;
                    case '*':
                        stack.push(number1*number);
                        break;
                    case '%':
                        stack.push(number1/number);
                        break;
                }
            }
        }
        return (Integer)stack.pop();
    }

    /**
     * Returns the precedence of operator
     * @param ch is character
     * @return case number to reflect.
     */
    private int Precedence(char ch)
    {
        if(ch == '+' || ch == '-')
        {
            return 1;
        }
        else if(ch == '*' || ch == '/' || ch =='%')
        {
            return 2;
        }
        else
        {
            return -1;
        }
    }
}
