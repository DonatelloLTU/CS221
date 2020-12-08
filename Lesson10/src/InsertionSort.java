import java.util.Collection;
import java.util.Iterator;

/**
 * InsertionSort implements sort from Sorter
 * @author Donatas Vasauskas
 * @version 2020-12-01.01
 */
public class InsertionSort implements Sorter {

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Comparable<? super T>> Collection sort(Collection<T> collection)
    {
        Class<? extends Collection> collectionClass = collection.getClass();


        T[] array = (T[]) new Comparable[collection.size()];
        Iterator<T> iterator = collection.iterator();
        for (int i = 0; i < array.length; i++)
        {
            array[i] = iterator.next();
        }

        for (int i = 1; i < array.length; i++)
        {
            T currItem = array[i];
            int sorterPos = i;

            while (sorterPos > 0 && array[sorterPos-1].compareTo(currItem) > 0)
            {
                array[sorterPos] = array[sorterPos-1];
                sorterPos--;
            }
            array[sorterPos] = currItem;
        }

        Collection<T> toReturn;
        try
        {
            toReturn = (Collection<T>) collectionClass.getDeclaredConstructor().newInstance();
        }
        catch (Exception ignored)
        {
            return null;
        }
        for (int i = 0; i < array.length; i++)
        {
            toReturn.add(array[i]);
        }
        return toReturn;
    }
}