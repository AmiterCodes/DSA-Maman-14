package me.amitnave.dsamaman14;
import java.util.Hashtable;

public class Solutions {

    public static int originalAlgorithm(int[] array, SolutionTracker tracker) {
        int uniqueSize = 1;
        for(int i = tracker.recordPlacement(1); tracker.greater(array.length, i); tracker.recordPlacement(i++)) {
            boolean unique = tracker.recordPlacement(true);
            for(int j = tracker.recordPlacement(0); tracker.greater(uniqueSize, j); tracker.recordPlacement(j++)) {
                if(tracker.equals(array[j], array[i])) {
                    unique = tracker.recordPlacement(false);
                    j = tracker.recordPlacement(uniqueSize);
                }
            }
            if(unique) {
                tracker.recordPlacement(++uniqueSize);
                array[uniqueSize - 1] = tracker.recordPlacement(array[i]);
            }
        }
        return uniqueSize;
    }

    public static int insertionSortBased(int[] array, SolutionTracker tracker) {
        int length = tracker.recordPlacement(array.length);
        insertionSort(array, length ,tracker);

        return countUniqueSorted(array, tracker, length);
    }

    public static int optimalBased(int[] array, SolutionTracker tracker) {
        int length = tracker.recordPlacement(array.length);
        mergeSort(array, tracker);

        return countUniqueSorted(array, tracker, length);
    }

    public static int countingBased(int[] array, SolutionTracker tracker) {
        int length = tracker.recordPlacement(array.length);
        int[] countingArray = new int[101];

        for (int i = tracker.recordPlacement(0); tracker.greater(length, i); tracker.recordPlacement(i++)) {
            tracker.recordPlacement(countingArray[array[i]]++);
        }

        int uniqueSize = 0;

        for (int i = tracker.recordPlacement(0); tracker.greater(countingArray.length, i); tracker.recordPlacement(i++)) {
            if(tracker.greater(countingArray[i], 0)) {
                tracker.recordPlacement(uniqueSize++);
            }
        }

        return uniqueSize;
    }

    public static int hashBased(int[] array, SolutionTracker tracker) {
        Hashtable<Integer, Boolean> table = tracker.recordPlacement(new Hashtable<>());

        int length = tracker.recordPlacement(array.length);

        for (int i = tracker.recordPlacement(0); tracker.greater(length, i); tracker.recordPlacement(i++)) {
            if(!tracker.equals(table.get(array[i]), true)) {
                table.put(array[i], true);
            }
        }
        int uniqueSize = 0;
        for (int i = tracker.recordPlacement(0); tracker.greater(101, i); tracker.recordPlacement(i++)) {
            if(table.containsKey(i)) {
                tracker.recordPlacement(uniqueSize++);
            }
        }

        return uniqueSize;
    }










    // Helper methods for the sorting based algorithms
    private static int countUniqueSorted(int[] array, SolutionTracker tracker, int length) {
        int uniqueSize = tracker.recordPlacement(1);

        if(tracker.equals(length,1)) return uniqueSize;

        for(int i = tracker.recordPlacement(1); tracker.greater(length, i); tracker.recordPlacement(i++)) {
            if(!tracker.equals(array[i], array[i-1])) {
                tracker.recordPlacement(uniqueSize++);
            }
        }

        return uniqueSize;
    }


    // METHOD FROM GEEKS FOR GEEKS WEBSITE (WITH ADDED SOLUTION TRACKER)
    private static void merge(int[] arr, int l, int m, int r, SolutionTracker tracker)
    {
        // Find sizes of two sub-arrays to be merged
        int n1 = tracker.recordPlacement(m - l + 1);
        int n2 = tracker.recordPlacement(r - m);

        /* Create temp arrays */
        int[] L = tracker.recordPlacement(new int[n1]);
        int[] R = tracker.recordPlacement(new int[n2]);

        /*Copy data to temp arrays*/
        for (int i = tracker.recordPlacement(0); tracker.greater(n1, i); tracker.recordPlacement(++i))
            L[i] = tracker.recordPlacement(arr[l + i]);
        for (int j = tracker.recordPlacement(0); tracker.greater(n2, j); tracker.recordPlacement(++j))
            R[j] = tracker.recordPlacement(arr[m + 1 + j]);

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = tracker.recordPlacement(0), j = tracker.recordPlacement(0);

        // Initial index of merged subarry array
        int k = l;
        while (tracker.greater(n1, i) && tracker.greater(n2, j)) {
            if (!tracker.greater(L[i],R[j])) {
                arr[k] = tracker.recordPlacement(L[i]);
                tracker.recordPlacement(i++);
            }
            else {
                arr[k] = tracker.recordPlacement(R[j]);
                tracker.recordPlacement(j++);
            }
            tracker.recordPlacement(k++);
        }

        /* Copy remaining elements of L[] if any */
        while (tracker.greater(n1, i)) {
            arr[k] = tracker.recordPlacement(L[i]);
            tracker.recordPlacement(i++);
            tracker.recordPlacement(k++);
        }

        /* Copy remaining elements of R[] if any */
        while (tracker.greater(n2, j)) {
            arr[k] = tracker.recordPlacement(R[j]);
            tracker.recordPlacement(j++);
            tracker.recordPlacement(k++);
        }
    }


    // METHOD FROM GEEKS FOR GEEKS WEBSITE (WITH ADDED SOLUTION TRACKER)
    // Main function that sorts arr[l..r] using
    // merge()
    private static void mergeSort(int[] arr, int l, int r, SolutionTracker tracker)
    {
        if (tracker.greater(r, l)) {
            // Find the middle point
            int m = tracker.recordPlacement(l + (r-l)/2);

            // Sort first and second halves
            mergeSort(arr, l, m, tracker);
            mergeSort(arr, m + 1, r, tracker);

            // Merge the sorted halves
            merge(arr, l, m, r, tracker);
        }
    }

    // METHOD FROM GEEKS FOR GEEKS WEBSITE (WITH ADDED SOLUTION TRACKER)
    private static void mergeSort(int[] array, SolutionTracker tracker) {
        mergeSort(array, 0, array.length - 1, tracker);
    }

    // METHOD FROM GEEKS FOR GEEKS WEBSITE (WITH ADDED SOLUTION TRACKER)
    private static void insertionSort(int[] array, int n, SolutionTracker tracker)
    {
        int i, key, j;
        for (i = tracker.recordPlacement(1); tracker.greater(n, i); tracker.recordPlacement(i++))
        {
            key = tracker.recordPlacement(array[i]);
            j = tracker.recordPlacement(i - 1);

            while (tracker.greater(j, -1) && tracker.greater(array[j], key))
            {
                array[j + 1] = tracker.recordPlacement(array[j]);
                j = tracker.recordPlacement(j - 1);
            }
            array[j + 1] = tracker.recordPlacement(key);
        }
    }
}
