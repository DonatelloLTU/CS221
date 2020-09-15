public interface DeckADT
{
    /**
     * Method to deal the cards from the deck
     * @return card, deals a random card from the deck to the player
     */
    public CardADT deal();

    /**
     * Method to get array of cards
     * @return cards from the array of the cards
     */
    public CardADT[] getCards ();

    /**
     * Method to shuffle all the cards in the deck
     */
    public void shuffle();

    @Override
    public String toString();
}
