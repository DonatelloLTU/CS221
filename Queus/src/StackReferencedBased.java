
/**
 * StackReferencedBased class implements Stack interface
 * @author Donatas Vasauskas
 * @version 2020-10-21.01
 */
public class StackReferencedBased implements Stack {
    Node top;

    /**
     * Constructor for the class
     * top is initialized as null
     */
    public StackReferencedBased()
    {
        top = null;
    }

    /**
     * Check if the stack is empty by checking is the stacks top is not null
     * @return true if empty
     * @return false if not empty
     */
    public boolean isEmpty()
    {
        return top == null;
    }

    /**
     * Remove and return the top of the stack if stack not empty
     * @return top Integer of the stack
     */
    public Object pop()
    {
        if (!isEmpty()) {
            Node i = top;
            top = top.next;
            return i.item;
        }
        else
        {
            throw new StackException("pop() is not available because stack is empty");
        }
    }

    /**
     * Remove all the items from the stack.
     */
    public void popAll()
    {

        top = null;

    }

    /**
     * Add new integer to the top of the stack
     * @param obj is an obj which is going to be placed on the top of the stack
     */
    public void push(Object obj)
    {
        try {
            top = new Node(obj, top);
        }
        catch (StackException exception)
        {
            System.out.println("Push is not available!");
        }
    }

    /**
     * Return the top of the stack if the stack is not empty
     * @return top Integer of the stack
     */
    public Object peek()
    {
        if(!isEmpty()) {
            return top.item;
        }
        else
        {
            throw new StackException("peek() not available because stack is empty");
        }
    }
}
