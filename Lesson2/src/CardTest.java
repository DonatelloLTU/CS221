import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;


/**
 * Test for the card class
 * @author Donatas Vasauskas
 * @version 2020-09-11.01
 */
public class CardTest
{
    Card card;

    @Before
    public void before()
    {
        card = new Card(1, 1, true);
    }

    @After
    public void after()
    {
        card = null;
    }

    /*
     * Test to make sure card returns correct suit of the card
     */
    @Test
    public void getSuitTest()
    {
        Assert.assertEquals(1, card.getSuit() );
    }

    /*
     * Test to make sure card returns correct value of the card
     */
    @Test
    public void getValueTest()
    {
        Assert.assertEquals(1, card.getValue());
    }

    /*
     * Test to make sure card is visible
     */
    @Test
    public void showCardTest()
    {
        Assert.assertTrue(card.visible);
    }

    /*
     * Test to make sure suit name is returned correctly
     */
    @Test
    public void getSuitNameTest()
    {
        Assert.assertSame("Hearts", card.getSuitName());
    }

    /*
     * Test to make sure value of the card is returned properly
     */
    @Test
    public void getStringName()
    {
        Assert.assertSame("A", card.getStringName());
    }
}
