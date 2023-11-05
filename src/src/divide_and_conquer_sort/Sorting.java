package divide_and_conquer_sort;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your implementation of various divide & conquer sorting algorithms.
 */

public class Sorting {

    /**
     * Implement merge sort.
     * <p>
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     * <p>
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     * <p>
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     * <p>
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     * <p>
     * Hint: You may need to create a helper method that merges two arrays
     * back into the original T[] array. If two data are equal when merging,
     * think about which subarray you should pull from first.
     * <p>
     * You may assume that the passed in array and comparator are both valid
     * and will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        // Recursively split array into 2

        // Base case
        if (arr.length <= 1) {
            return;
        }

        // Recursive case
        else {
            int midPoint = arr.length / 2;

            // Get left split
            T[] leftSplit = (T[]) new Object[midPoint];
            for (int i = 0; i < midPoint; i++) {
                leftSplit[i] = arr[i];
            }

            // Get right split
            T[] rightSplit = (T[]) new Object[arr.length - midPoint];
            for (int i = 0, j = midPoint; j < arr.length; i++, j++) {
                rightSplit[i] = arr[j];
            }

            mergeSort(leftSplit, comparator);
            mergeSort(rightSplit, comparator);

            merge(arr, leftSplit, rightSplit, comparator);
        }
    }

    /**
    * Helper function to merge left and right sub-arrays
    *
    * @param <T>        Data type to sort.
    * @param mainArray  The main array that will be merged into.
    * @param leftArray  The left sub-array set to be merged.
    * @param rightArray The right sub-array set to be merged.
    * @param comparator The Comparator used to compare the data in arr.
    */
    private static <T> void merge(T[] mainArray, T[] leftArray, T[] rightArray, Comparator<T> comparator) {

        int l = 0, r = 0, m = 0;

        // Merge two sub-arrays by sorting
        while (l < leftArray.length && r < rightArray.length) {

            int compareVale = comparator.compare(leftArray[l], rightArray[r]);

            // Left sub-array element is smaller or values are equal
            if (compareVale <= 0) {
                mainArray[m++] = leftArray[l++];
            }

            // Right sub-array element smaller
            else {
                mainArray[m++] = rightArray[r++];
            }
        }

        //  Add remaining left sub-array elements
        while (l < leftArray.length) {
            mainArray[m++] = leftArray[l++];
        }

        //  Add remaining right sub-array elements
        while (r < rightArray.length) {
            mainArray[m++] = rightArray[r++];
        }
    }


    /**
     * Implement LSD (least significant digit) radix sort.
     * <p>
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     * <p>
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     * <p>
     * Feel free to make an initial O(n) passthrough of the array to
     * determine k, the number of iterations you need.
     * <p>
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     * <p>
     * You may use an ArrayList or LinkedList if you wish, but it should only
     * be used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with merge sort. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     * <p>
     * Do NOT use anything from the Math class except Math.abs().
     * <p>
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     */
    public static void lsdRadixSort(int[] arr) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }
}
