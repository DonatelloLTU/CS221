/**
 * This class holds the fabled kSmallest method that returns the
 * kth smallest element in an array.
 *
 * @author Richard Mace
 * @author Gary Thompson
 * @author dvasauskas
 * @version 2020.9.1.3
 */
public class Main {
private static int[] array = {7,2,25,39,1,24,11,8,3, 10, 13,34, 17, 4, 22, 12, 33, 18, 21, 48, 27 };
    public static void main (String[] args)
    {
        int k = 17;
        System.out.println(kSmallest(k, array, 0, array.length - 1) + " is the "+ k + "th smallest in the array");
    }

    /**
     * This method finds the kth (5th, 9th, 100th) smallest element in an array of any size.
     *
     * @param k The index of the smallest element in the array
     * @param array The array in which we are searching
     * @param first The first index of the partition we are searching
     * @param last The last index of the partition we are searching
     * @return The kth smallest element in the array (3rd smallest or 100th smallest)
     */
    public static int kSmallest(int k, int[] array, int first, int last)
    {


        int temp, leftIndex, rightIndex, pivot, pivotIndex;

        leftIndex = first;
        rightIndex = last;
        pivot = array[first];
        pivotIndex = first;

        while (leftIndex < rightIndex){
            if(array[leftIndex + 1] < pivot){
                array[leftIndex] = array[leftIndex + 1];
                leftIndex++;
            }
            else{
                temp = array[rightIndex];
                array[rightIndex] = array[leftIndex + 1];
                rightIndex--;
                if(temp < pivot){
                    array[leftIndex] = temp;
                    leftIndex++;
                }else{
                    array[leftIndex + 1] = temp;
                }
            }
        }

        array[leftIndex] = pivot;
        pivotIndex = leftIndex;



        //put math in parentheses
        if (k < pivotIndex - first + 1)
        {
            return kSmallest(k, array, first, pivotIndex - 1);
        }
        else if (k == pivotIndex - first + 1)
        {
            return pivot;
        }
        else
        {
            return kSmallest(k - (pivotIndex - first + 1), array, pivotIndex + 1, last);
        }
        //return 1;
    }

}
