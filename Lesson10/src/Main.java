import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import  java.time.Instant;
import java.time.Duration;

/**
 * Main class to test all the sorters, calculate time for method to run and write it to csv file
 * @author Donatas Vasauskas
 * @version 2020-12-01.01
 */
public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\dvasauskas\\Desktop\\Software Projects\\IntelliJ\\CS221\\Lesson10\\SortComparisson.csv");
        OutputStream out;
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);
        System.out.println("20k elements:");
        elements20000();
        System.out.println();
        System.out.println("40k elements");
        elements40000();
        System.out.println();
        System.out.println("60k elements");
        elements60000();
        System.out.println();
        System.out.println("80k elements");
        elements80000();
        System.out.println();
        System.out.println("100k elements");
        elements100000();

    }

    /**
     * elements200000 method creates 3 different Arraylists, one unsorted, one nearly sorted, and one sorted, then runs sorters on them and calculates the time it takes to run
     */
    public static void elements20000() {

        ArrayList<Integer> al, alNearly, alSorted;
        al = new ArrayList<>();
        alNearly = new ArrayList<>();
        alSorted = new ArrayList<>();
        Random rand = new Random();
        QuickSort qs = new QuickSort();
        MergeSort ms = new MergeSort();
        InsertionSort is = new InsertionSort();
        int size = 20000;

        for (int i = 0; i < size; i++) {
            Integer intRn = rand.nextInt(500000);
            al.add(intRn);
        }
        Instant start = Instant.now();
        //qs.sort(al);
        Instant finish = Instant.now();
        long elapsedTime = Duration.between(start, finish).toNanos();
        System.out.println("Quick sort with not sorted collection took total of " + elapsedTime + "nanos");

        Instant start1 = Instant.now();
        ms.sort(al);
        Instant finish1 = Instant.now();
        long elapsedTime1 = Duration.between(start1, finish1).toNanos();
        System.out.println("Mergesort with not sorted took total of " + elapsedTime1 + "nanos");

        Instant start2 = Instant.now();
        is.sort(al);
        Instant finish2 = Instant.now();
        long elapsedTime2 = Duration.between(start2, finish2).toNanos();
        System.out.println("Insertion Sort with not sorted took total of " + elapsedTime2 + "nanos");

        for (int i = 0; i < size; i++) {
            Integer intRn = i;
            if (i % 1000 == 0) {
                intRn = rand.nextInt(500000);
                alNearly.add(intRn);
            } else {
                alNearly.add(intRn);
            }
        }
        System.out.println();
        Instant start3 = Instant.now();
        //qs.sort(alNearly);
        Instant finish3 = Instant.now();
        long elapsedTime3 = Duration.between(start3, finish3).toNanos();
        System.out.println("Quick sort with nearly sorted collection took total of " + elapsedTime3 + "nanos");

        Instant start4 = Instant.now();
        ms.sort(alNearly);
        Instant finish4 = Instant.now();
        long elapsedTime4 = Duration.between(start4, finish4).toNanos();
        System.out.println("Merge sort with nearly sorted collection took total of " + elapsedTime4 + "nanos");

        Instant start5 = Instant.now();
        is.sort(alNearly);
        Instant finish5 = Instant.now();
        long elapsedTime5 = Duration.between(start5, finish5).toNanos();
        System.out.println("Insertion sort with nearly sorted collection took total of " + elapsedTime5 + "nanos");

        for (int i = 0; i < size; i++) {
            Integer intRn = i;
            alSorted.add(intRn);
        }
        System.out.println();
        Instant start6 = Instant.now();
        //qs.sort(alSorted);
        Instant finish6 = Instant.now();
        long elapsedTime6 = Duration.between(start6, finish6).toNanos();
        System.out.println("Quick sort with sorted collection took total of " + elapsedTime6 + "nanos");

        Instant start7 = Instant.now();
        ms.sort(alSorted);
        Instant finish7 = Instant.now();
        long elapsedTime7 = Duration.between(start7, finish7).toNanos();
        System.out.println("Merge sort with sorted collection took total of " + elapsedTime7 + "nanos");

        Instant start8 = Instant.now();
        is.sort(alSorted);
        Instant finish8 = Instant.now();
        long elapsedTime8 = Duration.between(start8, finish8).toNanos();
        System.out.println("Insertion sort with sorted collection took total of " + elapsedTime8 + "nanos");
    }

    /**
     * elements400000 method creates 3 different Arraylists, one unsorted, one nearly sorted, and one sorted, then runs sorters on them and calculates the time it takes to run
     */
    public static void elements40000() {

        ArrayList<Integer> al, alNearly, alSorted;
        al = new ArrayList<>();
        alNearly = new ArrayList<>();
        alSorted = new ArrayList<>();
        Random rand = new Random();
        QuickSort qs = new QuickSort();
        MergeSort ms = new MergeSort();
        InsertionSort is = new InsertionSort();
        int size = 40000;

        for (int i = 0; i < size; i++) {
            Integer intRn = rand.nextInt(500000);
            al.add(intRn);
        }
        Instant start = Instant.now();
        //qs.sort(al);
        Instant finish = Instant.now();
        long elapsedTime = Duration.between(start, finish).toNanos();
        System.out.println("Quick sort with not sorted collection took total of " + elapsedTime + "nanos");

        Instant start1 = Instant.now();
        ms.sort(al);
        Instant finish1 = Instant.now();
        long elapsedTime1 = Duration.between(start1, finish1).toNanos();
        System.out.println("Mergesort with not sorted took total of " + elapsedTime1 + "nanos");

        Instant start2 = Instant.now();
        is.sort(al);
        Instant finish2 = Instant.now();
        long elapsedTime2 = Duration.between(start2, finish2).toNanos();
        System.out.println("Insertion Sort with not sorted took total of " + elapsedTime2 + "nanos");

        for (int i = 0; i < size; i++) {
            Integer intRn = i;
            if (i % 1000 == 0) {
                intRn = rand.nextInt(500000);
                alNearly.add(intRn);
            } else {
                alNearly.add(intRn);
            }
        }
        System.out.println();
        Instant start3 = Instant.now();
        //qs.sort(alNearly);
        Instant finish3 = Instant.now();
        long elapsedTime3 = Duration.between(start3, finish3).toNanos();
        System.out.println("Quick sort with nearly sorted collection took total of " + elapsedTime3 + "nanos");

        Instant start4 = Instant.now();
        ms.sort(alNearly);
        Instant finish4 = Instant.now();
        long elapsedTime4 = Duration.between(start4, finish4).toNanos();
        System.out.println("Merge sort with nearly sorted collection took total of " + elapsedTime4 + "nanos");

        Instant start5 = Instant.now();
        is.sort(alNearly);
        Instant finish5 = Instant.now();
        long elapsedTime5 = Duration.between(start5, finish5).toNanos();
        System.out.println("Insertion sort with nearly sorted collection took total of " + elapsedTime5 + "nanos");

        for (int i = 0; i < size; i++) {
            Integer intRn = i;
            alSorted.add(intRn);
        }
        System.out.println();
        Instant start6 = Instant.now();
        //qs.sort(alSorted);
        Instant finish6 = Instant.now();
        long elapsedTime6 = Duration.between(start6, finish6).toNanos();
        System.out.println("Quick sort with sorted collection took total of " + elapsedTime6 + "nanos");

        Instant start7 = Instant.now();
        ms.sort(alSorted);
        Instant finish7 = Instant.now();
        long elapsedTime7 = Duration.between(start7, finish7).toNanos();
        System.out.println("Merge sort with sorted collection took total of " + elapsedTime7 + "nanos");

        Instant start8 = Instant.now();
        is.sort(alSorted);
        Instant finish8 = Instant.now();
        long elapsedTime8 = Duration.between(start8, finish8).toNanos();
        System.out.println("Insertion sort with sorted collection took total of " + elapsedTime8 + "nanos");
    }

    /**
     * elements600000 method creates 3 different Arraylists, one unsorted, one nearly sorted, and one sorted, then runs sorters on them and calculates the time it takes to run
     */
    public static void elements60000()
    {

        ArrayList<Integer> al, alNearly, alSorted;
        al = new ArrayList<>();
        alNearly = new ArrayList<>();
        alSorted = new ArrayList<>();
        Random rand = new Random();
        QuickSort qs = new QuickSort();
        MergeSort ms = new MergeSort();
        InsertionSort is = new InsertionSort();
        int size = 60000;

        for(int i = 0; i < size; i++)
        {
            Integer intRn = rand.nextInt(500000);
            al.add(intRn);
        }
        Instant start = Instant.now();
        //qs.sort(al);
        Instant finish = Instant.now();
        long elapsedTime = Duration.between(start, finish).toNanos();
        System.out.println("Quick sort with not sorted collection took total of " + elapsedTime+ "nanos");

        Instant start1 = Instant.now();
        ms.sort(al);
        Instant finish1 = Instant.now();
        long elapsedTime1 = Duration.between(start1, finish1).toNanos();
        System.out.println("Mergesort with not sorted took total of " + elapsedTime1 + "nanos");

        Instant start2 = Instant.now();
        is.sort(al);
        Instant finish2 = Instant.now();
        long elapsedTime2 = Duration.between(start2, finish2).toNanos();
        System.out.println("Insertion Sort with not sorted took total of " + elapsedTime2 + "nanos");

        for(int i = 0; i < size; i++)
        {
            Integer intRn = i;
            if (i%1000 == 0)
            {
                intRn = rand.nextInt(500000);
                alNearly.add(intRn);
            }
            else
            {
                alNearly.add(intRn);
            }
        }
        System.out.println();
        Instant start3 = Instant.now();
        //qs.sort(alNearly);
        Instant finish3 = Instant.now();
        long elapsedTime3 = Duration.between(start3, finish3).toNanos();
        System.out.println("Quick sort with nearly sorted collection took total of " + elapsedTime3 + "nanos");

        Instant start4 = Instant.now();
        ms.sort(alNearly);
        Instant finish4 = Instant.now();
        long elapsedTime4 = Duration.between(start4, finish4).toNanos();
        System.out.println("Merge sort with nearly sorted collection took total of " + elapsedTime4 + "nanos");

        Instant start5 = Instant.now();
        is.sort(alNearly);
        Instant finish5 = Instant.now();
        long elapsedTime5 = Duration.between(start5, finish5).toNanos();
        System.out.println("Insertion sort with nearly sorted collection took total of " + elapsedTime5 + "nanos");

        for(int i = 0; i<size; i++)
        {
            Integer intRn = i;
            alSorted.add(intRn);
        }
        System.out.println();
        Instant start6 = Instant.now();
        //qs.sort(alSorted);
        Instant finish6 = Instant.now();
        long elapsedTime6 = Duration.between(start6, finish6).toNanos();
        System.out.println("Quick sort with sorted collection took total of " + elapsedTime6 + "nanos");

        Instant start7 = Instant.now();
        ms.sort(alSorted);
        Instant finish7 = Instant.now();
        long elapsedTime7 = Duration.between(start7, finish7).toNanos();
        System.out.println("Merge sort with sorted collection took total of " + elapsedTime7 + "nanos");

        Instant start8 = Instant.now();
        is.sort(alSorted);
        Instant finish8 = Instant.now();
        long elapsedTime8 = Duration.between(start8, finish8).toNanos();
        System.out.println("Insertion sort with sorted collection took total of " + elapsedTime8 + "nanos");
    }

    /**
     * elements800000 method creates 3 different Arraylists, one unsorted, one nearly sorted, and one sorted, then runs sorters on them and calculates the time it takes to run
     */
    public static void elements80000()
    {

        ArrayList<Integer> al, alNearly, alSorted;
        al = new ArrayList<>();
        alNearly = new ArrayList<>();
        alSorted = new ArrayList<>();
        Random rand = new Random();
        QuickSort qs = new QuickSort();
        MergeSort ms = new MergeSort();
        InsertionSort is = new InsertionSort();
        int size = 80000;

        for(int i = 0; i < size; i++)
        {
            Integer intRn = rand.nextInt(500000);
            al.add(intRn);
        }
        Instant start = Instant.now();
        // //qs.sort(al);
        Instant finish = Instant.now();
        long elapsedTime = Duration.between(start, finish).toNanos();
        System.out.println("Quick sort with not sorted collection took total of " + elapsedTime+ "nanos");

        Instant start1 = Instant.now();
        ms.sort(al);
        Instant finish1 = Instant.now();
        long elapsedTime1 = Duration.between(start1, finish1).toNanos();
        System.out.println("Mergesort with not sorted took total of " + elapsedTime1 + "nanos");

        Instant start2 = Instant.now();
        is.sort(al);
        Instant finish2 = Instant.now();
        long elapsedTime2 = Duration.between(start2, finish2).toNanos();
        System.out.println("Insertion Sort with not sorted took total of " + elapsedTime2 + "nanos");

        for(int i = 0; i < size; i++)
        {
            Integer intRn = i;
            if (i%1000 == 0)
            {
                intRn = rand.nextInt(500000);
                alNearly.add(intRn);
            }
            else
            {
                alNearly.add(intRn);
            }
        }
        System.out.println();
        Instant start3 = Instant.now();
        ////qs.sort(alNearly);
        Instant finish3 = Instant.now();
        long elapsedTime3 = Duration.between(start3, finish3).toNanos();
        System.out.println("Quick sort with nearly sorted collection took total of " + elapsedTime3 + "nanos");

        Instant start4 = Instant.now();
        ms.sort(alNearly);
        Instant finish4 = Instant.now();
        long elapsedTime4 = Duration.between(start4, finish4).toNanos();
        System.out.println("Merge sort with nearly sorted collection took total of " + elapsedTime4 + "nanos");

        Instant start5 = Instant.now();
        is.sort(alNearly);
        Instant finish5 = Instant.now();
        long elapsedTime5 = Duration.between(start5, finish5).toNanos();
        System.out.println("Insertion sort with nearly sorted collection took total of " + elapsedTime5 + "nanos");

        for(int i = 0; i<size; i++)
        {
            Integer intRn = i;
            alSorted.add(intRn);
        }
        System.out.println();
        Instant start6 = Instant.now();
        // //qs.sort(alSorted);
        Instant finish6 = Instant.now();
        long elapsedTime6 = Duration.between(start6, finish6).toNanos();
        System.out.println("Quick sort with sorted collection took total of " + elapsedTime6 + "nanos");

        Instant start7 = Instant.now();
        ms.sort(alSorted);
        Instant finish7 = Instant.now();
        long elapsedTime7 = Duration.between(start7, finish7).toNanos();
        System.out.println("Merge sort with sorted collection took total of " + elapsedTime7 + "nanos");

        Instant start8 = Instant.now();
        is.sort(alSorted);
        Instant finish8 = Instant.now();
        long elapsedTime8 = Duration.between(start8, finish8).toNanos();
        System.out.println("Insertion sort with sorted collection took total of " + elapsedTime8 + "nanos");
    }

    /**
     * elements1000000 method creates 3 different Arraylists, one unsorted, one nearly sorted, and one sorted, then runs sorters on them and calculates the time it takes to run
     */
    public static void elements100000()
    {

        ArrayList<Integer> al, alNearly, alSorted;
        al = new ArrayList<>();
        alNearly = new ArrayList<>();
        alSorted = new ArrayList<>();
        Random rand = new Random();
        QuickSort qs = new QuickSort();
        MergeSort ms = new MergeSort();
        InsertionSort is = new InsertionSort();
        int size = 100000;

        for(int i = 0; i < size; i++)
        {
            Integer intRn = rand.nextInt(500000);
            al.add(intRn);
        }
        Instant start = Instant.now();
        // //qs.sort(al);
        Instant finish = Instant.now();
        long elapsedTime = Duration.between(start, finish).toNanos();
        System.out.println("Quick sort with not sorted collection took total of " + elapsedTime+ "nanos");

        Instant start1 = Instant.now();
        ms.sort(al);
        Instant finish1 = Instant.now();
        long elapsedTime1 = Duration.between(start1, finish1).toNanos();
        System.out.println("Mergesort with not sorted took total of " + elapsedTime1 + "nanos");

        Instant start2 = Instant.now();
        is.sort(al);
        Instant finish2 = Instant.now();
        long elapsedTime2 = Duration.between(start2, finish2).toNanos();
        System.out.println("Insertion Sort with not sorted took total of " + elapsedTime2 + "nanos");

        for(int i = 0; i < size; i++)
        {
            Integer intRn = i;
            if (i%1000 == 0)
            {
                intRn = rand.nextInt(500000);
                alNearly.add(intRn);
            }
            else
            {
                alNearly.add(intRn);
            }
        }
        System.out.println();
        Instant start3 = Instant.now();
        ////qs.sort(alNearly);
        Instant finish3 = Instant.now();
        long elapsedTime3 = Duration.between(start3, finish3).toNanos();
        System.out.println("Quick sort with nearly sorted collection took total of " + elapsedTime3 + "nanos");

        Instant start4 = Instant.now();
        ms.sort(alNearly);
        Instant finish4 = Instant.now();
        long elapsedTime4 = Duration.between(start4, finish4).toNanos();
        System.out.println("Merge sort with nearly sorted collection took total of " + elapsedTime4 + "nanos");

        Instant start5 = Instant.now();
        is.sort(alNearly);
        Instant finish5 = Instant.now();
        long elapsedTime5 = Duration.between(start5, finish5).toNanos();
        System.out.println("Insertion sort with nearly sorted collection took total of " + elapsedTime5 + "nanos");

        for(int i = 0; i<size; i++)
        {
            Integer intRn = i;
            alSorted.add(intRn);
        }
        System.out.println();
        Instant start6 = Instant.now();
        // //qs.sort(alSorted);
        Instant finish6 = Instant.now();
        long elapsedTime6 = Duration.between(start6, finish6).toNanos();
        System.out.println("Quick sort with sorted collection took total of " + elapsedTime6 + "nanos");

        Instant start7 = Instant.now();
        ms.sort(alSorted);
        Instant finish7 = Instant.now();
        long elapsedTime7 = Duration.between(start7, finish7).toNanos();
        System.out.println("Merge sort with sorted collection took total of " + elapsedTime7 + "nanos");

        Instant start8 = Instant.now();
        is.sort(alSorted);
        Instant finish8 = Instant.now();
        long elapsedTime8 = Duration.between(start8, finish8).toNanos();
        System.out.println("Insertion sort with sorted collection took total of " + elapsedTime8 + "nanos");
    }
}
