import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements QueueInterface<E>{

    public E[] items;
    public int size, front, back;
    public final int maxSize = 20;


    public Queue()
    {
        items = (E[]) new Object[maxSize];
        size = 0;
        front = 0;
        back = 0;
    }

    /**
     * Method to get the head of the queue
     * @return head of the queue
     */
    @Override
    public E peek() {

        return element();
    }

    /**
     * Method to get the head of the queue
     * @return head of the queue
     */
    @Override
    public E element() throws NoSuchElementException {

        if(isEmpty())
        {
            throw new NoSuchElementException();
        }
        else
        {
            return items[front];
        }
    }

    /**
     * Method to add element to the queue
     * @param e is an element which will get added to the queue
     * @return true if item is added
     * @return false if item was not added
     */
    @Override
    public boolean offer(Object e) {
        return add(e);
    }

    /**
     * Method to add element to the queue
     * @param e is an element which will get added to the queue
     * @return true if item is added
     * @return false if item was not added
     */
    @Override
    public boolean add(Object e) {
        if(size == maxSize)
        {
            return false;
        }
        else
        {
            items[back] = (E) e;
            back = (back + 1) % items.length;
            ++size;
            return true;
        }
    }

    /**
     * Method to get and remove head of the queue
     * @return head of the queue
     */
    @Override
    public E poll() {

        return remove();
    }

    /**
     * Method to remove head of the queue
     * @return head of the queue
     * @throws NoSuchElementException if the queue is empty.
     */
    @Override
    public E remove() throws NoSuchElementException {
        if(isEmpty())
        {
            throw new NoSuchElementException();
        }
        else
        {
            E removed = items[front];
            front = (front + 1) % maxSize;
            --size;
            return removed;
        }
    }

    /**
     * Method to check is the queue empty;
     * @return size which is euqal to 0
     */
    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    /**
     * Method to get the size of the queue
     * @return size of the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Method to clear the queue
     */
    @Override
    public void clear() {
        for(int i = 0; i <= size; i++)
        {
            items[i] = null;
        }
        front = 0;
        back = 0;
        size = 0;
    }

    /**
     * Method to check does the queue contains the object
     * @param e is an object
     * @return true is object is found
     * @return false if object is not found
     */
    @Override
    public boolean contains(Object e) {

        for(int i = 0; i < size; i++)
        {
            if(items[i].equals(e))
            {
                return true;
            }
        }
        return false;
    }


    /**
     * Method implemented by COllections interace
     *
     */
    @Override
    public boolean addAll(Collection arg0) {
        return false;
    }

    @Override
    public boolean containsAll(Collection arg0) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public boolean remove(Object arg0) {
        return false;
    }

    @Override
    public boolean removeAll(Collection arg0) {
        return false;
    }

    @Override
    public boolean retainAll(Collection arg0) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return null;
    }

    @Override
    public Object[] toArray(Object[] arg0) {
        return null;
    }
}