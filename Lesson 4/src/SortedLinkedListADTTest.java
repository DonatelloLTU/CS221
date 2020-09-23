import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class to test SOrted Linked list
 * @author Donatas Vasauskas
 * @version 2020-09-23.01
 */
public class SortedLinkedListADTTest {

    SortedLinkedList sorted;
    Node node, head;

    @Before
    public void before()
    {
        sorted = new SortedLinkedList();

        sorted.insert(10);
    }

    @After
    public void after()
    {
        sorted = null;
    }

    /**
     * Test to check the size of the list.
     */
    @Test
    public void size() {
        assertEquals(1, sorted.size());
    }


    /**
     * Test to insert item into linked list
     */
    @Test
    public void insert() {

        sorted.insert(1);
        assertEquals(2, sorted.size());

    }

    /**
     * Test to remove item into linked list
     */
    @Test
    public void remove() {
        sorted.insert(5);
        assertEquals(2, sorted.size());


        sorted.remove(5);
        assertFalse(sorted.contains(5));

    }

    /**
     * Test to check if the list is empty
     */
    @Test
    public void empty() {
        assertEquals(1, sorted.size());
    }


    /**
     * Test to remove all items from the list
     */
    @Test
    public void removeAll() {
        sorted.insert(4);

        sorted.removeAll();
        assertEquals(0, sorted.size());
    }




}