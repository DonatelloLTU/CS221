/**
 * Palindrome class
 * @author DOnatas Vasauskas
 * @version 2020-11-05.01
 */
public class Palindrome {

    public  String palendrome = "";

    public Palindrome(String palendrome) {

        this.palendrome=palendrome;
    }

    /**
     * Method to check if string is palendrome
     * @return true if the string is palendrome
     * @return false if the string is not palendrome
     */
    public boolean isPalindrome()
    {
        String s = new String();
        Queue queue = new Queue();
        StackReferencedBased stack = new StackReferencedBased();
        String nonPalendrom = palendrome.replaceAll("[^a-zA-Z0-9]", "");
        String lower = nonPalendrom.toLowerCase();

        for(int i = 0; i < lower.length(); i++)
        {
            s = "" + lower.charAt(i);
            queue.add(s);
            stack.push(s);
        }
        while(!queue.isEmpty())
        {
            if(!queue.poll().equals(stack.pop()))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to get the string
     * @return string
     */
    public String getString()
    {
        return palendrome;
    }
}
