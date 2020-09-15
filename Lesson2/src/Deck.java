import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Random;

/**
 * Class Deck creates a Deck of cards from the class Cards and stores it in Array.
    @Author Donatas Vasauskas
    @Version 2020-09-10.01
 */
public class Deck
{
    Card[] deck;
    int last;
/**
    Constructor for the class Deck,
    Stores instance of cards and stores them in array of deck.
 */
    public Deck()
    {
        deck = new Card[52];
        int deckIndex = 0;
        for (int i = 1; i <= 4; i++)
        {
            for (int j = 2; j < 15; j++)
            {
                deck[deckIndex] = new Card (i, j, true);
                deckIndex++;
            }
        }
        shuffle(); //after creation method is called to shuffle the deck array
        //getDeckCards(); //print out statement to check if the cards are shuffled

    }

    public Card returnDeck(int i)
    {

        return deck[i];
    }
    /**
        Method shuffle, takes array using random number puts cards in random order within array.
     */
    public void shuffle()
    {
        Random random = new Random();

        for (int i = deck.length-1; i > 0; i--)
        {
            int randomInteger = (int)(Math.random()*(i+1));
            Card card = deck[i];
            deck[i] = deck[randomInteger];
            deck[randomInteger] = card;
        }
    }



    /**
     * Method to deal cards
     */
    public void deal()
    {

    }
    /**
        Method to check if array is shuffled,
        @return String to see is the deck shuffled.
     */
    public String getDeckCards()
    {
        int j = 0;
        for (int i =0 ; i < deck.length; i++)
        {
            System.out.println(deck[j]);
            j++;
        }
       return "Done";
    }

}
