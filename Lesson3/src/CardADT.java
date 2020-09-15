
public interface CardADT
{
    /**
     * Method to get value of the card
     * @return values to represent the value of the card
     */
    public int getValue();

    /**
     * Method to get suit of the card
     * @return suits to represent specific suit of the card
     */
    public int getSuit();

    /**
     * Method to show the card, makes the visibility of the card to true
     */
    public void show();

    /**
     * Method to hide the card, makes the visibility of the card to false
     */
    public void hide();

    /**
     * Method to get suit name of the specific card
     * @return suits is a string to represent name of the specific suit
     */
    public String getSuitName();

    /**
     * Method to get value name of the specific card
     * @return values is a string to represent name of the specific value
     */
    public String getStringName();

    @Override
    public String toString();
}
