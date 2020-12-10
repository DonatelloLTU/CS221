import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Card column class is used to set tableaus, freecll, deck....
 * @author Donatas Vasauskas
 * @version 2020-12-02.01
 */
public class CardColumn implements Iterable<Card>{
    //Arraylist to hava all the cards.
    ArrayList<Card> cards = new ArrayList<Card>();

    /**
     * Peek method return instance of the card
     * @return cards from the array
     */
    public Card peek()
    {
        return cards.get(cards.size() - 1);
    }

    /**
     * Pop method to remove card
     * @return
     */
    public Card pop()
    {
        int last = size() - 1;
        Card temporary = cards.get(last);
        cards.remove(last);
        return temporary;
    }

    /**
     * Push ethod to push cards into arraylist
     * @param card is instance of the card
     */
    public void push(Card card)
    {
        cards.add(card);
    }

    /**
     * Size method to get the size of the arraylist
     * @return int size
     */
    public int size()
    {
        return cards.size();
    }

    /**
     * Method to shuffle the cards within the arraylist
     */
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * Method to clear the array of the cards.
     */
    public void clear()
    {
        cards.clear();
    }



    /**
     * Method for adding card
     * @param card instance of the crad
     * @return true
     */
    public boolean addingThisCard(Card card)
    {
        if ((this.size() == 0) ||
                (this.peek().getValue().ordinal() - 1 == card.getValue().ordinal() && this.peek().getSuit().getColor() != card.getSuit().getColor())) {
            return true;
        }
        return false;
    }

    /**
     * Method to check if the card is removable
     * @return true
     */
    public boolean isRemovable()
    {
        return true;
    }

    /**
     * Method to go over arraylist and find specific card
     * @return specific card
     */
    @Override
    public Iterator<Card> iterator()
    {
        return cards.iterator();
    }

    /**
     * Method to get card to string
     * @return string of the card
     */
    public String toString()
    {
        return cards.toString() + "\n";
    }

    /**
     * Overide in the way method to push card
     * @param card instance of the card
     */
    public void pushIgnore(Card card)
    {
        cards.add(card);
    }

    /**
     * Method overide to pop
     * @return card instance of pop
     */
    public Card popIgnore()
    {
        int lastIndex = size()-1;
        Card card = cards.get(lastIndex);
        cards.remove(lastIndex);
        return card;
    }

}