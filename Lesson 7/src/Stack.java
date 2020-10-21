/**
 * Interface of the stack
 * @author Donatas Vasauskas
 * @version 2020-10-21
 */

public interface Stack {

    /**
     * Check if the stack is empty by checking is the stacks top is not null
     * @return true if empty
     * @return false if not empty
     */
    public boolean isEmpty();

    /**
     * Remove and return the top of the stack if stack not empty
     * @return top Integer of the stack
     */
    public Integer pop();

    /**
     * Remove all the items from the stack.
     */
    public void popAll();


    /**
     * Add new integer to the top of the stack
     * @param integer is an Integer which is going to be placed on the top of the stack
     */
    public void push(Integer integer);

    /**
     * Get the top of the stack if the stack is not empty
     * @return top Integer of the stack
     */
    public Integer peek();
}
