import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Queue interface
 * @author Donatas Vasauskas
 * @version 2020-11-1.01
 */
public interface QueueInterface<E> extends Collection<E> {
    /**
     * Method to get the head of the queue
     * @return head of the queue
     */
    public E peek();

    /**
     * Method to get head of the queue
     * @return head of the queue
     * @throws NoSuchElementException if queue is empty
     */
    public E element() throws NoSuchElementException;

    /**
     * Method to add element to the queue
     * @param e is an element which will get added to the queue
     * @return true if item is added
     * @return false if item was not added
     */
    public boolean offer(E e);

    /**
     * Method to get and remove head of the queue
     * @return head of the queue
     */
    public E poll();

    /**
     * Method to remove head of the queue
     * @return head of the queue
     * @throws NoSuchElementException if the queue is empty.
     */
    public E remove() throws NoSuchElementException;
}
