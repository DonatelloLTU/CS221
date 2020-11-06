/**
 * Node class
 * @author Donatas Vasauskas
 * @version 2020-09-22.01
 */
public class Node
{
    Node next;
    Object item;

    /**
     * Constructor for Node class
     */
    public Node(Object item)
    {
        this.item = item;
        next = null;
    }

    /**
     * Constructor method
     * @param item item itself
     * @param next reference to the node
     */
    public Node(Object item, Node next)
    {
        this.item = item;
        this.next = next;
    }

    /**
     * Mutator method for next node
     * @param next is node to set next node
     */
    public void setNext(Node next)
    {
        this.next = next;
    }
    /**
     * Accessor method to get next node
     * @return next is next node
     */
    public Node getNext()
    {
        return next;
    }

    /**
     * Mutator method to sset the item
     * @param item is item to be set in node
     */
    public void setItem(Object item)
    {
        this.item = item;
    }

    /**
     * Accessor method to get item
     * @return item is item within the node
     */
    public Object getItem()
    {
        return item;
    }
}
