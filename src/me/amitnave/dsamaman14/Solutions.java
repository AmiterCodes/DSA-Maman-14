package me.amitnave.dsamaman14;
import java.util.Hashtable;

public class Solutions {

    @SolutionMeta(name = "Original", timeComplexity = "n^2")
    public static int originalAlgorithm(int[] array, SolutionTracker tracker) {
        int uniqueSize = 1;
        for(int i = tracker.place(1); tracker.greater(array.length, i); tracker.place(i++)) {
            boolean unique = tracker.place(true);
            for(int j = tracker.place(0); tracker.greater(uniqueSize, j); tracker.place(j++)) {
                if(tracker.equals(array[j], array[i])) {
                    unique = tracker.place(false);
                    j = tracker.place(uniqueSize);
                }
            }
            if(unique) {
                tracker.place(++uniqueSize);
                array[uniqueSize - 1] = tracker.place(array[i]);
            }
        }
        return uniqueSize;
    }

    @SolutionMeta(name = "Insertion Sort Based", timeComplexity = "n^2")
    public static int insertionSortBased(int[] array, SolutionTracker tracker) {
        int length = tracker.place(array.length);
        insertionSort(array, length ,tracker);

        return countUniqueSorted(array, tracker, length);
    }

    @SolutionMeta(name = "Optimal (Merge) Sort Based", timeComplexity = "n log n")
    public static int optimalBased(int[] array, SolutionTracker tracker) {
        int length = tracker.place(array.length);
        mergeSort(array, tracker);

        return countUniqueSorted(array, tracker, length);
    }

    @SolutionMeta(name = "Counting Array Based", timeComplexity = "n")
    public static int countingBased(int[] array, SolutionTracker tracker) {
        int length = tracker.place(array.length);
        int[] countingArray = new int[101];

        for (int i = tracker.place(0); tracker.greater(length, i); tracker.place(i++)) {
            tracker.place(countingArray[array[i]]++);
        }

        int uniqueSize = 0;

        for (int i = tracker.place(0); tracker.greater(countingArray.length, i); tracker.place(i++)) {
            if(tracker.greater(countingArray[i], 0)) {
                tracker.place(uniqueSize++);
            }
        }

        return uniqueSize;
    }

    @SolutionMeta(name = "HashTable Based", timeComplexity = "n")
    public static int hashBased(int[] array, SolutionTracker tracker) {
        Hashtable<Integer, Boolean> table = tracker.place(new Hashtable<>());

        int length = tracker.place(array.length);

        for (int i = tracker.place(0); tracker.greater(length, i); tracker.place(i++)) {
            if(!tracker.equals(table.get(array[i]), true)) {
                table.put(array[i], true);
            }
        }
        int uniqueSize = 0;
        for (int i = tracker.place(0); tracker.greater(101, i); tracker.place(i++)) {
            if(table.containsKey(i)) {
                tracker.place(uniqueSize++);
            }
        }

        return uniqueSize;
    }





/// HELPER METHODS BELLOW


    // Helper methods for the sorting based algorithms
    private static int countUniqueSorted(int[] array, SolutionTracker tracker, int length) {
        int uniqueSize = tracker.place(1);

        if(tracker.equals(length,1)) return uniqueSize;

        for(int i = tracker.place(1); tracker.greater(length, i); tracker.place(i++)) {
            if(!tracker.equals(array[i], array[i-1])) {
                tracker.place(uniqueSize++);
            }
        }

        return uniqueSize;
    }


    // METHOD FROM GEEKS FOR GEEKS WEBSITE (WITH ADDED SOLUTION TRACKER)
    private static void merge(int[] arr, int l, int m, int r, SolutionTracker tracker)
    {
        // Find sizes of two sub-arrays to be merged
        int n1 = tracker.place(m - l + 1);
        int n2 = tracker.place(r - m);

        /* Create temp arrays */
        int[] L = tracker.place(new int[n1]);
        int[] R = tracker.place(new int[n2]);

        /*Copy data to temp arrays*/
        for (int i = tracker.place(0); tracker.greater(n1, i); tracker.place(++i))
            L[i] = tracker.place(arr[l + i]);
        for (int j = tracker.place(0); tracker.greater(n2, j); tracker.place(++j))
            R[j] = tracker.place(arr[m + 1 + j]);

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = tracker.place(0), j = tracker.place(0);

        // Initial index of merged subarry array
        int k = l;
        while (tracker.greater(n1, i) && tracker.greater(n2, j)) {
            if (!tracker.greater(L[i],R[j])) {
                arr[k] = tracker.place(L[i]);
                tracker.place(i++);
            }
            else {
                arr[k] = tracker.place(R[j]);
                tracker.place(j++);
            }
            tracker.place(k++);
        }

        /* Copy remaining elements of L[] if any */
        while (tracker.greater(n1, i)) {
            arr[k] = tracker.place(L[i]);
            tracker.place(i++);
            tracker.place(k++);
        }

        /* Copy remaining elements of R[] if any */
        while (tracker.greater(n2, j)) {
            arr[k] = tracker.place(R[j]);
            tracker.place(j++);
            tracker.place(k++);
        }
    }


    // METHOD FROM GEEKS FOR GEEKS WEBSITE (WITH ADDED SOLUTION TRACKER)
    // Main function that sorts arr[l..r] using
    // merge()
    private static void mergeSort(int[] arr, int l, int r, SolutionTracker tracker)
    {
        if (tracker.greater(r, l)) {
            // Find the middle point
            int m = tracker.place(l + (r-l)/2);

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
        for (i = tracker.place(1); tracker.greater(n, i); tracker.place(i++))
        {
            key = tracker.place(array[i]);
            j = tracker.place(i - 1);

            while (tracker.greater(j, -1) && tracker.greater(array[j], key))
            {
                array[j + 1] = tracker.place(array[j]);
                j = tracker.place(j - 1);
            }
            array[j + 1] = tracker.place(key);
        }
    }
}
