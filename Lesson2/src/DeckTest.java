import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/**
 * DeckTest to test the deck
 * @author Donatas Vasauskas
 * @version 2020-09-11.01
 */
public class DeckTest
{
    Deck deck, deck2;

    @Before
    public void before()
    {
        deck = new Deck();
        deck2 = new Deck();
    }

    @After
    public void after()
    {
        deck = null;
        deck2 = null;
    }

    /*
    Test to make sure deck size is 52 cards
     */
    @Test
    public void deck52Test()
    {
        Assert.assertEquals(52, deck.deck.length);
    }

    /*
    Test to check that two decks are not the same, and they are shuffled.
     */
    @Test
    public void shuffleTest()
    {
        Assert.assertNotEquals(deck, deck2);
    }
}
