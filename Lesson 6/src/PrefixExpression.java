import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * PrefixExpression class check users prefix expression and uses random numbers generated to calculate the prefix condition
 * @author Donatas Vasauskas
 * @version 2020-10-06
 */
public class PrefixExpression {

    static String  expression;
    static boolean check;
    int size;
    int last;
    int end;
    static Map hm = new HashMap();
    Random rd;
    static Scanner sc = new Scanner(System.in);


    /**
     * Constructor for the class
     */
    public PrefixExpression(String preExp)
    {
        expression = preExp;
        size = expression.length();
        hm = new HashMap<String, Integer>();
        rd = new Random();
        int upper = 99;
        for (char ch ='a'; ch <= 'z'; ++ch)
        {
            hm.put(ch, rd.nextInt(upper) );
        }
        //isPrefix(expression);
        System.out.println("Expression is prefix:" + isPrefix());
        System.out.println("Result of Prefix Expression equals: " + calculate());
    }
    /**
     * isPrefix method to check if the value PrefixExpression or not
     * @return true or false boolean depending on the expression
     */
    public boolean isPrefix()
    {

        last = endOfPrefix(0, size - 1);
        if (last >= 0 && last == size -1) {
            check = true;
            return true;
        }
        else
        {
            check = false;
            return false;
        }
    }

    /**
     * calculate method uses calculations to calculate the prefixExpression
     * @return double number which is value after calculations
     */
    static double calculate() {

        if (check == true) {
            char operator = expression.charAt(0);
            //expression = expression.substring(1);
            //int chNum = Character.getNumericValue(operator);
            char firstOperand = expression.charAt(1);
            char secondOperand = expression.charAt(2);
            String a = hm.get(firstOperand).toString();
            System.out.println(firstOperand + " equals to " + a);
            String b = hm.get(secondOperand).toString();
            System.out.println(secondOperand + " equals to " + b);
            double i = Integer.parseInt(a);
            double j = Integer.parseInt(b);


            //expression = expression.substring(1);
            //if (chNum >=10 && chNum <=35)
            //{
            //  return chNum;
            //}
            //else {
            //  double i = calculate();
            //double  j = calculate();
            if (operator == '+') {

                return i + j;
            } else if (operator == '-') {
                return i - j;
            } else if (operator == '*') {
                return i * j;
            } else if (operator == '/') {
                return i / j;
            }

        }
        return 0;
    }

    private int endOfPrefix(int first, int last)
    {

        if (first < 0 || first > last)
        {
            return -1;
        }

        char ch = expression.charAt(first);
        int chNum = Character.getNumericValue(ch);
        if(chNum >=10 && chNum<=35)
        {
            return first;
        }
        else if (ch == '+'||ch=='-'||ch=='*'||ch=='/')
        {
            end = endOfPrefix(first + 1, last);

            if (end > -1) {
                return endOfPrefix(end + 1, last);
            } else {
                return -1;
            }
        }
        else
        {
            return -1;
        }
    }
    public static void main(String[] args) {

            System.out.println("Enter prefix expression such as (+ab)");

            PrefixExpression pe = new PrefixExpression(sc.nextLine());
        }


    }

