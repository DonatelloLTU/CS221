import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;


/**
 * Test for the CardColumn class
 * @author Donatas Vasauskas
 * @version 2020-09-11.01
 */
public class CardColumnTests {
    CardColumn column;
    Card card, card1;

    @Before
    public void before() {
        column = new CardColumn();
        card = new Card(Suit.HEARTS, Value.ACE);
        card1 = new Card(Suit.CLUBS, Value.ACE);
    }

    @After
    public void after() {
        column = null;
        card = null;
        card1 = null;
    }

    /**
     * Test method to test push method of Card Column class
     */
    @Test
    public void pushTest()
    {
        System.out.println("Testing Push method of CardColumn");
        column.push(card);
        Assert.assertEquals(card, column.peek());
    }
    /*
    *Test method to test peek method
     */
    @Test
    public void peekTest()
    {
        System.out.println("Testing Peek method");
        column.push(card);
        Assert.assertEquals(card, column.peek());
    }

    /**
     * Method test to test pop method of Column Card class
     */
    @Test
    public void popTest()
    {
        System.out.println("Testing Pop method for CardColumn class");
        column.push(card);
        Assert.assertEquals(card, column.pop());
        Assert.assertEquals(0, column.size());
    }

    /**
     * Method to test size method of CardColumn
     */
    @Test
    public void sizeTest()
    {
        System.out.println("Testing size method of CardColumn class");
        Assert.assertEquals(0, column.size());
        column.push(card);
        Assert.assertEquals(1, column.size());
    }

    /**
     * Method to test clear method of CardColumn class
     */
    @Test
    public void clearTest()
    {
        System.out.println("Testing clear method of CardColumn class");
        column.push(card);
        Assert.assertEquals(card, column.peek());
        column.push(card1);
        Assert.assertEquals(card1, column.peek());
        column.clear();
        Assert.assertEquals(0, column.size());
    }


}