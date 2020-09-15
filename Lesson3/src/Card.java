/**
 * Class card creates instance of the card with values, rank, and visibility.
 * @author Donatas Vasauskas
 * @version 2020-09-10.01
 */
public class Card
{
    int suits, values;
    final int Hearts = 1, Spades = 2, Diamonds = 3, Clubs = 4;

    boolean visible;
    /**
        Constructor to create card
        @param suit is integer to represent suit of the card,
        @param value is an integer to represent value of the card,
        @param visible boolean to represent is the card visible or not.
     */

    public Card(int suit, int value, boolean visible)
    {
        suits = suit;
        values = value;
        this.visible = true;
    }




    /**
     * Method getSuit accessor to get the suit of the card
     * @return suits represents the suit of the card in integer.
     */
    public int getSuit()
    {
        return suits;
    }

    /**
     *Method getValue accessor to get the value of the card
     * @return values represents the values of the card
     */
    public int getValue()
    {
        return values;
    }



    /**
     * Void method to make cards visibility true
     */
    public void show()
    {
        visible = true;
    }

    /**
     * Void method to make card visibility false
     */
    public void hide()
    {
        visible = false;
    }

    /**
     * Method to show name of the suit for the card using cases
     * @return "Hearts" returns string to represent Heart suit for the card
     * @return "Spades" returns string to represent Spades suit for the card
     * @return "Diamonds" returns string to represent Diamonds suit for the card
     * @return "Clubs" returns string to represent Clubs suit for the card
     * @return "No" returns string to represent that none of the cases was used, probably an error.
     */
    public String getSuitName()
    {
    switch (suits)
    {
        case Hearts: return "Hearts";
        case Spades: return "Spades";
        case Diamonds: return "Diamonds";
        case Clubs: return "Clubs";
        default: return "No";
    }
    }

    /**
     * Method to get string value of the card
     * @return Value of the string to represent specific card.
     */
    public String getStringName()
    {
        switch (values)
        {
            //case 1: return "A";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
            case 8: return "8";
            case 9: return "9";
            case 10: return "10";
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            case 14: return "Ace";
            default: return "No";
        }
    }
    @Override
    public String toString()
    {

            return getStringName() + " of " + getSuitName();

    }
}
