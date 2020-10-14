import java.util.*;

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
        System.out.println();
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


                ArrayList ar = new ArrayList<Character>();
                ArrayList ar1 = new ArrayList<String>();
                while (!Character.isLetter(expression.charAt(0))) {

                    ar.add(expression.charAt(0));
                    expression = expression.substring(1);
                }
                while (!expression.isEmpty())
                {

                    ar1.add(expression.charAt(0));
                    expression = expression.substring(1);
                }


                    char operand1 = ar1.get(0).toString().charAt(0);
                    ar1.remove(0);
                    String a = hm.get(operand1).toString();
                    double i = Integer.parseInt(a);
                    System.out.println("Your numbers are: ");
                    System.out.println(i);
                    while (!ar.isEmpty()) {
                        char operator = ar.get(0).toString().charAt(0);
                        ar.remove(0);
                        char operand2 = ar1.get(0).toString().charAt(0);
                        ar1.remove(0);


                        String b = hm.get(operand2).toString();

                        double j = Integer.parseInt(b);
                        System.out.println(j);
                        switch (operator) {
                            case '+' -> i = (i + j);
                            case '-' -> i = (i - j);
                            case '*' -> i = (i * j);
                            case '/' -> i = (i / j);
                        }

                    }
                    return i;




            }

        else
        {
            System.out.println("Enter proper prefix expression!");
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

