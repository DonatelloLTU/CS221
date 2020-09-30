/**
 * LinkedListADT
 * @author Donatas Vasauskas
 * @version 2020-09-18.01
 */

public interface SortedLinkedListADT
{


    /**
     * Method to get size of LinkedList
     * @return int for the size of linked list
     */
    public int size();

    /**
     *Method to add index(item) to the linked list
     */
    public void insert(Integer index) throws Exception;

    /**
     * Method to remove index(item) from the linked list
     */
    public void remove(Integer index) throws Exception;

    /**
     * Method to check if the linked list is empty
     * @return boolean
     */
    public boolean empty();

    /**
     * MEthod to remove all the indexes(items) from the linked list
     */
    public void removeAll();

    /**
     * Method to check if linked list contains specific index(item)
     * @return true or false depending on condition
     */
    public boolean contains(Integer index);



}
