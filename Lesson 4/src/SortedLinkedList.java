/**
 * SortedLinkedList class implements SortedLinkedListADT
 * @author Donatas Vasauskas
 * @version 2020-09-28.01
 */
public class SortedLinkedList implements SortedLinkedListADT {

    int size;
    Node head, current;
    public SortedLinkedList()
    {
        size = 0;
        head = null;
    }


    /**
     * Method to get size of the list
     * @return size is an integer to get size of the list
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Inserts item to the list
     * @param item
     * @throws Exception if the item already contains within the item
     */
    @Override
    public void insert(Integer item) throws Exception {
        if (contains(item) == true)
        {

            throw new Exception("Item already is within the list");

        }
        else {
            Node node1 = new Node(item);
            if (head == null) {
                head = node1;
                size++;
                return;

            }
            else if (item.compareTo(head.getItem()) < 0) {
                node1.next = head;
                head = node1;
                size++;
            }
            else
            {
                Node before = head;
                Node after = head.next;
                while(after != null)
                {
                    if(item.compareTo(after.item) < 0)
                    {
                        break;
                    }
                    before = after;
                    after = after.next;
                }
                node1.next = before.next;
                before.next = node1;
                size++;
            }
        }
    }

    /**
     * Removes item from the list
     * @param item
     * @throws Exception if item is not found
     */
    @Override
    public void remove(Integer item) throws Exception {
        if (!contains(item)) {
            throw new Exception("Item is not in the list already!");
        } else {
            if (head.item.compareTo(item) == 0) {
                head = head.next;
            } else {

                Node node1 = head;
                Node node2 = null;
                while (node1.next != null) {
                    if (node1.next.item.equals(item)) {
                        node1.next = node1.next.next;
                        break;
                    } else {
                        node2 = node1.next;
                        node1 = node1.next;
                    }
                    node2.next = null;
                }
            }
            size--;
        }
    }

    /**
     * Method make the list is empty
     * @return empty list
     */
    @Override
    public boolean empty()
    {
        return(head == null);
    }

    /**
     * Remove all the items from the list
     */
    @Override
    public void removeAll()
    {
        if(head == null)
        {
            return;
        }
        head = head.next;
        removeAll();
        size--;
    }

    /**
     * Method to find the item within the list
     * @param item
     * @return
     */
    @Override
    public boolean contains(Integer item)
    {
        while (head != null)
        {
            if (item.equals(head.item))
            {
                return true;
            }
            else
            {
                head = head.getNext();
                contains(item);
            }
        }
        return false;
    }

    /**
     * Print out what is in the list
     */
    public void print()
    {
        if(head != null)
        {
            current = head;
            while(current != null)
            {
                System.out.println(current.getItem());
                current = current.getNext();
            }
        }
    }


}
