
import jdk.jfr.StackTrace;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;
import static sun.awt.FontConfiguration.verbose;

/**
 * QueueArrayBasedTest class tests QueueArrayBased class methods
 * @author Donatas Vasauskas
 * @version 2020-11-10
 */
public class QueueArrayBasedTest<T> {

    QueueArrayBased<T> qu = new QueueArrayBased<T>();
    Object obj, obj1, obj2, obj3;

    @Before
    public void before()
    {
        obj = 7;
        obj1 = "John";
        obj2 = false;

        qu.add(obj);
        qu.add(obj1);
        qu.add(obj2);
    }

    @After
    public void after()
    {
        qu.clear();

    }

    /**
     * Test method to test peek method, we check front of array.
     */
    @Test
    public void peekTest()
    {
        if (verbose)
            System.out.println("Testing peek method");
        assertEquals(qu.peek(), 7);
    }

    /**
     * Test method to test poll method, we remove front off array and return new front
     */
    @Test
    public void pollTest()
    {
        if (verbose)
            System.out.println("Testing poll method");
        qu.poll();
        assertEquals(qu.peek(), "John");
    }


    /**
     * Test method to test offer, we clear QueueArrayBased and add new object, then we check it.
     */
    @Test
    public void offerTest()
    {
        if (verbose)
            System.out.println("Testing offer method");
        obj3 = 82;
        qu.clear();
        qu.offer(obj3);
        assertEquals(qu.peek(), 82);
    }

    /**
     * Test method to test contains method, we check does array contains specific object
     */
    @Test
    public void containsTest()
    {
        if (verbose)
            System.out.println("Testing contains method");
        assertTrue(qu.contains(false));
    }

    /**
     * Test method to test clear method, we clear the QueueArrayBased and check if it is empty.
     */
    @Test
    public void clearTest()
    {
        if (verbose)
            System.out.println("Testing clear method");
        assertFalse(qu.isEmpty());
        qu.clear();
        assertTrue(qu.isEmpty());
    }

    /**
     * Test method to test size.
     */
    @Test
    public void sizeTest()
    {
        if (verbose)
            System.out.println("Testing size method");
        assertEquals(qu.size(), 3);
    }

    /**
     * Test method to check iterator method hasNext
     */
    @Test
    public void hasNextTest()
    {
        if (verbose)
            System.out.println("Testing hasNext method");
        assertTrue(qu.iterator().hasNext());
    }

    /**
     * Test method to test iterator next method
     */
    @Test
    public void nextTest()
    {
        if (verbose)
            System.out.println("Testing next method");
        assertEquals(qu.iterator().next(), 7);
    }



}
