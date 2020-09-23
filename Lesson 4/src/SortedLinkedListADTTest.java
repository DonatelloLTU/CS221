import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedLinkedListADTTest {

    SortedLinkedList sorted;
    Node node;

    @Before
    public void before()
    {
        sorted = new SortedLinkedList();
        node =new Node(10);
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
        sorted.head = node;
        assertEquals(1, sorted.size());

    }

    @Test
    void remove() {
        sorted.head = node;
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
        sorted.head = node;
        head.next = node;
        assertEquals(2, sorted.size());
        while(head != null)
        {
            head = head.next;
            size--;
        }
        assertEquals(0, sorted.size());
    }




}