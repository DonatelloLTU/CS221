import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

/**
 * StackTest is a jUnit test class to test stack
 * @author Donatas Vasauskas
 * @version 2020-10-21.01
 */
class StackTest {

    StackReferencedBased stack = new StackReferencedBased();


    /**
     * Test for isEmpty method
     */
    @org.junit.jupiter.api.Test
    void isEmpty() {
        stack.popAll();
        System.out.println("Testing for isEmpty()");
        System.out.println("Expecting: true, actual: " + stack.isEmpty());
        assertTrue(stack.isEmpty());
        stack.push(4);
        System.out.println("Expecting: false, actual: " + stack.isEmpty());
        assertFalse(stack.isEmpty());

    }

    /**
     * Test for pop method
     */
    @org.junit.jupiter.api.Test
    void pop() {
        stack.popAll();
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
     * Test for popAll method
     */
    @org.junit.jupiter.api.Test
    void popAll() {
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
    @org.junit.jupiter.api.Test
    void push() {
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
    @org.junit.jupiter.api.Test
    void peek() {
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
}