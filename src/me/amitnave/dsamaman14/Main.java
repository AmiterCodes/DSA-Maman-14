package me.amitnave.dsamaman14;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Scanner scanner = new Scanner(System.in);
        int n;
        do {

            System.out.print("Please enter a value for N: ");

            n = scanner.nextInt();
            if (n < 1) {
                System.out.println(Color.RED + "(!) Value for N must be positive.");
            }
        } while (n < 1); // makes sure that values are positive.

        int[] array = generateArray(n);

        System.out.println(Color.YELLOW + "(!) Note: All algorithms are ran with the same input array.");

        runTrackers(array);

        scanner.next();
    }

    /**
     * tracks all of the solutions
     *
     * @param array array to run trackers on
     */
    private static void runTrackers(int[] array) throws InvocationTargetException, IllegalAccessException {
        boolean allEqual = true;
        int result = -1;
        for (Method method : Solutions.class.getMethods()) {

            // checks that method is a solution
            if (method.isAnnotationPresent(SolutionMeta.class)) {
                SolutionMeta meta = method.getAnnotation(SolutionMeta.class);

                // converts the method into a Solution interface using lambda, and also pass to a tracker, along with the fetched meta and array.
                int nextResult = trackSolution((arr, tracker) -> (int) method.invoke(null, arr, tracker), array, meta);

                // if the result is not default and is not equal the previous, we got a problem chief.
                if (result != -1 && result != nextResult) allEqual = false;
                result = nextResult;
            }

        }

        // makes sure that all algorithms give the same output.
        if (allEqual) {
            System.out.println(Color.GREEN_BOLD + "✓ All Algorithms give same output");
        } else {
            // should never happen ;)
            System.out.println(Color.RED_BOLD + "(!) Not all algorithms give same output");
        }
    }


    /**
     * Tracks and Prints results for a solution
     *
     * @param solution solution to track
     * @param array    array to input
     * @param meta     meta of solution
     * @return result of the solution given the array
     */
    public static int trackSolution(Solution solution, int[] array, SolutionMeta meta) throws InvocationTargetException, IllegalAccessException {

        SolutionTracker tracker = new SolutionTracker();
        int[] clonedArray = array.clone(); // gives the method a cloned array so changing it won't affect the original array.

        tracker.startStopwatch();

        // this just calls the method, all hail lambda interface definitions
        int result = solution.solve(clonedArray, tracker);

        tracker.stopStopwatch();

        tracker.print(meta, result);
        return result;
    }

    public static int[] generateArray(int length) {
        int[] array = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100) + 1;
        }
        return array;
    }


}
