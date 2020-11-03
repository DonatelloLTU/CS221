import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.Queue;

/**
 * Test class for interface of the test class
 * @author Donatas Vasauskas
 * @version 2020-11-1.01
 */
public class QueueTest<E> {

   // Queue<E> queue = new Queue<E>() {



    @Before
    public <E> void before()
    {
        Object obj = new String("Donatas");
        Object obj1 = new String("Vasauskas");
     //   queue.offer(obj);
       // queue.offer(obj1);
    }

    @After
    public void after()
    {
     //   queue = null;
    }

    @BeforeEach
    public void beforeEach()
    {
        TestInfo testInfo = new TestInfo() {
            @Override
            public String getDisplayName() {
                return null;
            }

            @Override
            public Set<String> getTags() {
                return null;
            }

            @Override
            public Optional<Class<?>> getTestClass() {
                return Optional.empty();
            }

            @Override
            public Optional<Method> getTestMethod() {
                return Optional.empty();
            }
        };
        System.out.println("Testing " + testInfo.getTestMethod().get().getName());
    }

    /**
     * Testing peek method
     */
    @Test
    public <E> void peekTest()
    {
        //assertEquals(queue.peek(), "Vasauskas");
    }

    /**
     * Test offer method
     */
    @Test
    public void offerTest()
    {
        Object obj2 = new String("Lithuania");
        //queue.offer(obj2);
        //assertEquals(queue.peek(), "Lithuania");
    }

    /**
     * Test poll method
     */
    @Test
    public void pollTest()
    {
        //assertEquals(queue.peek(), "Vasauskas");
        //queue.poll();
        //assertEquals(queue.peek(), "Donatas");
    }

    /**
     * Test remove method
     */
    @Test
    public void removeTest()
    {
        //assertEquals(queue.peek(), "Vasauskas");
        //queue.remove();
        //assertEquals(queue.peek(), "Donatas");
    }
}
