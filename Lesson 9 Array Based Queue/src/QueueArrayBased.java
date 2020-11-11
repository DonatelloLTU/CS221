import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Arrays;

public class QueueArrayBased<T> implements Queue, Comparable<T>{

    private T[] items;
    private int currentSize, front, back;
    private static int maxSize = 50;

   @SuppressWarnings("unchecked")
    public QueueArrayBased()
    {
        items = (T[]) new Object[maxSize];
        currentSize = 0;
        front = 0;
        back = 0;

    }

    @SuppressWarnings("unchecked")
    public QueueArrayBased(int maxSized)
    {
        maxSize = maxSized;
        items = (T[]) new Object[maxSize];
        currentSize = 0;
        front = 0;
        back = 0;
    }

    @Override
    public boolean offer(Object obj)
    {
        return add(obj);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean add(Object obj)
    {
        if (currentSize != maxSize)
        {
            items[back] = (T) obj;
            back = (back + 1) % items.length;
            ++currentSize;
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public T poll()
    {
        return remove();
    }

    @Override
    public T remove() throws NoSuchElementException
    {
        if (!isEmpty())
        {
            T removed = items[front];
            front = (front + 1) % maxSize;
            --currentSize;
            return removed;
        }
        else
        {
            throw new NoSuchElementException();
        }
    }

    @Override
    public T peek()
    {
        return element();
    }

    @Override
    public T element() throws NoSuchElementException
    {
        if(!isEmpty())
        {
            return items[front];
        }
        else
        {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean contains(Object obj)
    {
        for (int i = 0; i < currentSize; i++)
        {
            if (items[i].equals(obj))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new QueueIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public void clear()
    {
        for(int i = 0; i < currentSize - 1; i++)
        {
            items[i] = null;
        }
        currentSize = 0;
        front = 0;
        back = 0;
    }

    @Override
    public int size()
    {
        return currentSize;
    }
    @Override
    public boolean isEmpty()
    {
        return currentSize == 0;
    }


    @Override
    public int compareTo(T o) {
        return 0;
    }



    private class QueueIterator implements Iterator<T>
    {
        private int position = 0;

        @Override
        public boolean hasNext() {
            if (position < items.length)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        @Override
        public T next() {
            if (this.hasNext())
            {
                return items[position++];
            }
            else
            {
                return null;
            }
        }
    }

    
    //Methods below are default methods in order that program would compile
    //They must be implemented within the class

    /**
     * Default method implemented by java collections
     * @param o object
     * @return false
     */
    @Override
    public boolean remove(Object o) {
        return false;
    }

    /**
     * Default method implemented by java collections
     * @param c Collection
     * @return false
     */
    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    /**
     * Default method implemented by java collections
     * @param c collection
     * @return false
     */
    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    /**
     * Default method implemented by java collections
     * @param c collection
     * @return false
     */
    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    /**
     * Default method implemented by java collections
     * @param c
     * @return
     */
    @Override
    public boolean containsAll(Collection c) {
        return false;
    }
}
