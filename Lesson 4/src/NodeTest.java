import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Node test class
 * @author Donatas Vasauskas
 * @version 2020-09-23
 */
public class NodeTest {


    SortedLinkedList list;
    Integer item;

    /**
     * Builds everything for a test
     */
    @Before
    public void before() {

        list = new SortedLinkedList();
        list.insert(4);
        list.insert(55);
        list.insert(11);
        list.insert(33);
        item = 5;

    }


    /**
     * Takes all the values away after the test
     */
    @After
    public void after() {

        list = null;
        item = null;
    }

    /**
     * Test to set next
     */
    @Test
    public void setNextTest() {
        list = new SortedLinkedList();
        Integer setTestNode = 22;
        list.insert(22);
        assertTrue(list.contains(setTestNode));


    }


    /**
     * test to get next
     */
    @Test
    public void getNextTest() {
        assertTrue(list.contains(11));
    }

        /**
         * Test to set item
         */
        @Test
        public void setItemTest()
        {
            item = 6;
            list.insert(item);
            System.out.println("Test setItemTest");
            list.print();
            assertTrue(list.contains(item));
        }


    }

