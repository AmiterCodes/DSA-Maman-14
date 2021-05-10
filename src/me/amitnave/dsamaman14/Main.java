package me.amitnave.dsamaman14;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a value for n: ");

        int n = scanner.nextInt();

        trackOriginal(n);
        trackInsertion(n);
        trackOptimal(n);
        trackCounting(n);
        trackTable(n);
        scanner.next();
    }

    public static void trackOriginal(int n) {
        int[] array = generateArray(n);
        SolutionTracker tracker = new SolutionTracker();
        int[] clonedArray = array.clone();
        int result = Solutions.originalAlgorithm(array, tracker);
        tracker.print(n, "original", clonedArray, result);
    }

    public static void trackInsertion(int n) {
        int[] array = generateArray(n);
        SolutionTracker tracker = new SolutionTracker();
        int[] clonedArray = array.clone();
        int result = Solutions.insertionSortBased(array, tracker);
        tracker.print(n, "insertion sort based", clonedArray, result);
    }

    public static void trackOptimal(int n) {
        int[] array = generateArray(n);
        SolutionTracker tracker = new SolutionTracker();
        int[] clonedArray = array.clone();
        int result = Solutions.optimalBased(array, tracker);
        tracker.print(n, "optimal sort based", clonedArray, result);
    }

    public static void trackCounting(int n) {
        int[] array = generateArray(n);
        SolutionTracker tracker = new SolutionTracker();
        int[] clonedArray = array.clone();
        int result = Solutions.countingBased(array, tracker);
        tracker.print(n, "counting array based", clonedArray, result);
    }

    public static void trackTable(int n) {
        int[] array = generateArray(n);
        SolutionTracker tracker = new SolutionTracker();
        int[] clonedArray = array.clone();
        int result = Solutions.hashBased(array, tracker);
        tracker.print(n, "hash table based", clonedArray, result);
    }

    public static int[] generateArray(int length) {
        int[] array = new int[length];
        Random random = new Random();

        for(int i = 0; i < length; i++) {
            array[i] = random.nextInt(100) + 1;
        }
        return array;
    }


}
