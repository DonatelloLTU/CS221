import java.lang.reflect.Array;
import java.util.*;

/**
 * Merge sort implements sort methods from sorter
 * @author DOnatas Vasauskas
 * @version 2020-12-01.01
 */
public class MergeSort implements Sorter
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

        T[] tempArray = (T[]) new Comparable[collection.size()];
        mergeSort(array, tempArray, 0, array.length -1);

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

    private <T extends Comparable<? super T>> void merge(T[] array, T[] tempArray, int first, int mid, int last)
    {
        int first1 = first;
        int first2 = mid + 1;
        int last1 = mid;
        int last2 = last;

        int index = first;
        while ((first1 <= last1) && (first2 <= last2))
        {
            tempArray[index++] = (array[first1].compareTo(array[first2]) < 0) ? array[first1++] : array[first2++];
        }

        while (first1 <= last1)
        {
            tempArray[index++] = array[first1++];
        }
        while (first2 <= last2)
        {
            tempArray[index++] = array[first2++];
        }

        for (index = first; index <= last; index++) //Move the data to the actual array
        {
            array[index] = tempArray[index];
        }
    }

    private <T extends Comparable<? super T>> void mergeSort(T[] array, T[] tempArray, int first, int last)
    {
        if (first < last)
        {
            int mid = (first + last)/2;
            mergeSort(array, tempArray, first, mid);
            mergeSort(array, tempArray, mid + 1, last);
            merge(array, tempArray, first, mid, last);
        }
    }
}
