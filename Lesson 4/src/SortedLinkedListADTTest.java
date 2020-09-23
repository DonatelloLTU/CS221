import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class to test SOrted Linked list
 * @author Donatas Vasauskas
 * @version 2020-09-23.01
 */
class SortedLinkedListADTTest {

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


    @Test
    void size() {
        assertEquals(0, sorted.size());
    }

    @Test
    void insert() {

        sorted.insert(1);
        assertEquals(2, sorted.size());

    }

    @Test
    void remove() {
        sorted.insert(5);
        head.next = node;
        head = null;
        assertEquals(1, sorted.size());
    }

    @Test
    void empty() {
        assertEquals(0, sorted.size());
    }

    @Test
    void removeAll() {
        sorted.insert(4);
        head.next = node;
        assertEquals(2, sorted.size());
        while(head != null)
        {
            head = head.next;

        }
        assertEquals(0, sorted.size());
    }




}