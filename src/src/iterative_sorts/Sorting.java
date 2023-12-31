package iterative_sorts;

import java.util.Comparator;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {

    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {

        // Optimize 1: swapMade flag; array is sorted -> outer loop iteration break; optimizes outer-loop
        // Optimize 2: shorten stop index; right side sorted, reduce amount of comparisons; optimizes inner-loop

        int stopIndex = arr.length - 1;

        // Outer loop,
        while (stopIndex > 0) {

            // Inner loop variables
            int j = 0;
            int swapIndex = 0;
            boolean swapMade = false;

            // Inner loop
            while (j < stopIndex) {

                // Swap if current value is larger than next
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {

                    // Swap
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // Update variables
                    swapMade = true;
                    swapIndex = j;
                }

                // Increment pointer
                j++;
            }

            // Optimize: End sort early if iteration made no swap
            if (!swapMade) {
                break;
            }
            // Optimize: Update stop Index
            else {
                stopIndex = swapIndex;
            }
        }
    }


    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n^2)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {

        // Outer loop - Iterate backwards, assigning max value to last index
        for (int i = arr.length - 1; i > 0; i --) {

            // Inner loop - Find max value in sub-array arr[:outerLoopIndex]
            int maxValueIndex = 0;
            for(int j = 1; j <= i; j++) {

                if (comparator.compare(arr[j], arr[maxValueIndex]) > 0) {
                    maxValueIndex = j;
                }
            }

            // Swap max value with sub-array's end boundary
            T temp = arr[i];
            arr[i] = arr[maxValueIndex];
            arr[maxValueIndex] = temp;
        }
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {

        // Outer Loop - iterate through each index in array
        for (int i = 0; i < arr.length; i++) {

            // Inner loop - place index element correctly in left sorted half by swapping
            int j = i;
            // Swap if current value is smaller than previous
            while(j > 0 && comparator.compare(arr[j], arr[j - 1]) < 0) {
                T temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j --;
            }
        }
    }
}