
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
/**
 * Stack interface testing
 * @author Donatas Vasauskas
 * @version 2020-10-27.01
 */
public class StackTest {

    public Stack stack;

    public StackTest(Stack stack)
    {
        this.stack = stack;
    }

    /**
     * Test to check if the stack is empty.
     */
    @Test
    public final void isEmptyTest()
    {
        assertTrue(stack.isEmpty());
    }

    /**
     * Test to test if stack pop single object.
     */
    @Test
    public final void pop()
    {
        System.out.println("Testing for pop()");
        stack.push(4);
        System.out.println("Top of the stack: "+ stack.peek());
        System.out.println("Adding 5 to the stack");
        stack.push(5);
        System.out.println("Current top of the stack: "+ stack.peek());
        System.out.println("Adding 6 to the stack");
        stack.push(6);
        System.out.println("Current top of the stack: "+ stack.peek());
        System.out.println("Using pop method to remove the top of the stack");
        stack.pop();
        System.out.print("Expected top of the stack: 5, actual: " + stack.peek());
        assertEquals(5, stack.peek());
    }

    /**
     * Test to test if stack pops all
     */
    @Test
    public final void popAll() {
        stack.popAll();
        System.out.println("Testing popAll()");
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("Checking if stack is empty");
        System.out.println("Expected: false, actual: " + stack.isEmpty());
        System.out.println("Removing all items with popAll()");
        stack.popAll();
        System.out.println("Checking if stack is empty");
        System.out.println("Expected: true, actual: " + stack.isEmpty());
        assertTrue(stack.isEmpty());
    }

    /**
     * Test for push method
     */
    @Test
    public final void push() {
        stack.popAll();
        System.out.println("Testing push()");
        System.out.println("Checking if stack is empty");
        System.out.println("Expected: true, actual: " + stack.isEmpty());
        System.out.println("Adding 4 to the stack using push()");
        stack.push(4);
        System.out.println("Top of the stack: "+ stack.peek());
        System.out.println("Adding 5 to the stack push()");
        stack.push(5);
        System.out.println("Current top of the stack: "+ stack.peek());
        System.out.println("Adding 6 to the stack push()");
        stack.push(6);
        System.out.println("Current top of the stack: "+ stack.peek());
        assertEquals(6, stack.peek());

    }

    /**
     * Test for peek method
     */
    @Test
    public final void peek() {
        stack.popAll();
        System.out.println("Testing peek()");
        System.out.println("Checking if stack is empty");
        System.out.println("Expected: true, actual: " + stack.isEmpty());
        System.out.println("Adding 4 to the stack using push()");
        stack.push(4);
        System.out.println("Top of the stack: "+ stack.peek());
        System.out.println("Adding 5 to the stack push()");
        stack.push(5);
        System.out.println("Current top of the stack: "+ stack.peek());
        System.out.println("Adding 6 to the stack push()");
        stack.push(6);
        System.out.println("Current top of the stack: "+ stack.peek());
        assertEquals( 6, stack.peek());
    }

    /**
     * https://stackoverflow.com/questions/6724401/how-to-write-junit-tests-for-interfaces
     * @return
     */
    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                new Object[]{new StackReferencedBased()},
                new Object[]{new StackReferencedBased()}
        );
    }
}
