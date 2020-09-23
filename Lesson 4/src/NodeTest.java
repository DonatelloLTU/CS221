import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;

public class NodeTest {

    Node testNode1, testNode2, testNode3, headNode;
    LinkedList list;
    @Before
    public void before()
    {
        testNode1 = new Node(55);
        testNode2 = new Node(11);
        testNode3 = new Node(33, testNode2);
        headNode = new Node(4);
        list = new LinkedList();
        list.add(headNode);
        list.add(testNode1);
        list.add(testNode2);
        list.add(testNode3);
    }

    @After
    public void after()
    {
        testNode1 = null;
        testNode2 = null;
        testNode3 = null;
        headNode = null;
        list = null;
    }

    @Test
    public void setNextTest()
    {
        list = new LinkedList();
        Node setTestNode = new Node(22, testNode2);
        list.add(setTestNode);
        assertTrue(list.iterator().hasNext());

    }

    @Test
    public void getNextTest()
    {
        assertEquals(headNode, list.iterator().next());
    }

    @Test

}
