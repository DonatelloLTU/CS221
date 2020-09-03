import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Random;

/**
 Test for kSmall main method.
 @author Donatas Vasauskas
 @version 2020.09.03-01

*/

public class KthSmallestTest extends Main
{
    /*
    KSmallTest method is test to check is the kSmall method within main class is working,
    it asserts that kSmallest method returns correct k value.
    */
    @Test
    public void kSmallTest()
    {
        int fifty = 1;
        while (fifty <= 50) {
            int k;
            int array[] = randomArray();
            int sorted[] = Arrays.copyOf(array, array.length);
            Arrays.sort(sorted);

            k = (new Random()).nextInt(array.length); //index
            assertTrue(kSmallest(k + 1, array, 0, array.length - 1) == sorted[k]);
            fifty++;
        }

    }
    /*
    randomArray method called to create random array and is used for kSmallTest method
    @return randArray, which is randomly generated array with index bound between 1000 - 3999
    */
    private int[] randomArray()
    {
        Random rand = new Random();
        int[] randArray = new int[rand.nextInt(3000)+1000];
        boolean[] boolArray = new boolean[8001];
        int i = 0;
        while (i < randArray.length)
        {
            int j;
            j = rand.nextInt(4000)-8000;
            if (boolArray[j+8000] != true)
            {
                boolArray[j+8000] = true;
                randArray[i] = j;
                i++;
            }
        }
        return randArray;

    }
}
