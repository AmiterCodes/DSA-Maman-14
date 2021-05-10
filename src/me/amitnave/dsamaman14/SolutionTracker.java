package me.amitnave.dsamaman14;

public class SolutionTracker {
    private int comparisons = 0;
    private int placements = 0;

    public void print(int n, String algorithmName, int[] array, int result) {
        System.out.println("For the value of N = " + n + ", the " + algorithmName + " algorithm");
        System.out.println("committed " + comparisons + " comparisons and " + placements + " placements.");
        //System.out.print("Input array: ");
        //printArray(array);
        //System.out.println();
        System.out.println("Output: " + result);
    }

    /**
     * used when a placement is made to record it as a placement, simply returns the inserted value
     */
     public <T> T recordPlacement(T value) {
        placements++;
        return value;
    }

    /**
     * used to compare 2 numbers and records it to tracker
     * @param a the first number
     * @param b the second number
     * @return true if a is greater than b
     */
    public boolean greater(double a, double b) {
        comparisons++;
        return a > b;
    }

    /**
     * returns if 2 values are equal and records it to tracker
     * @param a first value
     * @param b second value
     * @return true if a is equal to b
     */
    public <T> boolean equals(T a, T b) {
        comparisons++;
        return a == b;
    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if(i != 0) System.out.print(" ,");
            System.out.print(array[i]);
        }
        System.out.print("]");
    }
}
