import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/**
 * Quick sort class implements sort method from sorter
 * @author Donatas Vasauskas
 * @version 2020-12-01.01
 */
public class QuickSort implements Sorter
{
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

        quickSort(array, 0, array.length - 1);

        Collection<T> returnCollection;
        try
        {
            returnCollection = (Collection<T>) collectionClass.getDeclaredConstructor().newInstance();
        }
        catch (Exception ignored)
        {
            return null;
        }
        for (int i = 0; i < array.length; i++)
        {
            returnCollection.add(array[i]);
        }
        return returnCollection;
    }

    private <T extends Comparable<? super T>> int partition(T[] array, int first, int last)
    {
        T temp, pivot;
        pivot = array[first];

        int last1 = first;

        for (int firstUnknown = first + 1; firstUnknown <= last; firstUnknown++)
        {
            if (array[firstUnknown].compareTo(pivot) < 0)
            {
                temp = array[firstUnknown];
                array[++last1] = temp;
            }
        }

        temp = array[first];
        array[first] = array[last1];
        array[last1] = temp;
        return last1;
    }

    private <T extends Comparable<? super T>> void quickSort(T[] array, int first, int last)
    {
        int pivot;

        if (first < last)
        {

            pivot = partition(array, first, last);

            quickSort(array, first, pivot - 1);
            quickSort(array, pivot + 1, last);
        }
    }
}
