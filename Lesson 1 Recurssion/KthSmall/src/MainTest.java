import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Richard Mace, Kyle Bentz
 */
class MainTest extends Main
{

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


    @Test
    public void kSmallestTest()
    {
        //Arrange
        Random random = new Random();
        int n, k, r, first, last;
        int[] array;
        int[] arraySorted;

        //Act
        n = random.nextInt(10) + 15;
        k = random.nextInt(n);
        array = new int[n];
        arraySorted = new int[n];
        first = 0;
        last = n;
        for(int i = 0; i < n; i++)  //filling the arrays with random numbers
        {
            r = random.nextInt(50);
            array[i] = r;
            arraySorted[i]= r;
        }

        //Debug system.outs.  Delete later.
        for(int i = 0; i < n; i++)
        {
            System.out.print(array[i] + ", ");
        }
        System.out.println("\nArray");
        for(int i = 0; i < n; i++)
        {
            System.out.print(arraySorted[i] + ", ");
        }
        System.out.println("\nSorted Array");

        //Sorting the array
        for (int i = 0; i < arraySorted.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arraySorted.length; j++){
                if (arraySorted[j] < arraySorted[index]){
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = arraySorted[index];
            arraySorted[index] = arraySorted[i];
            arraySorted[i] = smallerNumber;
        }

        //Debug system.outs.  Delete later.
        System.out.println("\nArray");

        for(int i = 0; i < n; i++)
        {
            System.out.print(array[i] + ", ");
        }

        System.out.println("\nSorted Array");

        for(int i = 0; i < n; i++)
        {
            System.out.print(arraySorted[i] + ", ");
        }

        //Assert

        //Needs changed to assertEquals once kSmallest method is implemented
        assertEquals(kSmallest(k, array, first, last), arraySorted[k-1]);
    }
}