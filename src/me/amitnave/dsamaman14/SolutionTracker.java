package me.amitnave.dsamaman14;

public class SolutionTracker {
    private int comparisons = 0;
    private int placements = 0;
    private long startTime;
    private long timeTook;

    /**
     * prints results to console
     * @param meta the metadata for the solution (known complexity and name)
     * @param result the result of the method
     */
    public void print(SolutionMeta meta, int result) {
        System.out.println();
        System.out.println(Color.YELLOW_BOLD + meta.name() + " algorithm results:");
        System.out.println(Color.WHITE + "committed " + Color.RESET + comparisons + Color.WHITE + " comparisons and " + Color.RESET + placements + Color.WHITE + " placements.");
        System.out.println("Known Average Time Complexity: O(" + Color.RESET + meta.timeComplexity() + Color.WHITE + ")");
        System.out.println("Output: " + Color.RESET +  result + Color.WHITE);
        if(timeTook > 0) {
            System.out.println("Time Took: " + Color.RESET + timeTook + "ms" + Color.WHITE);
        }
        System.out.println();
    }

    /**
     * used when a placement is made to record it as a placement, simply returns the inserted value
     */
     public <T> T place(T value) {
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

    public void startStopwatch() {
        startTime = System.nanoTime();
    }

    public void stopStopwatch() {
        timeTook = (System.nanoTime() - startTime) / 1000000;
    }
}
