package tests;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Assertions;

import static iterative_sorts.Sorting.*;


public class SortTests {

    @Nested
    class BubbleSortTests {

        @Test
        public void testBubbleSort1() {
            Integer[] input = {3, 2, 4};
            Integer[] expected = {2, 3, 4};

            bubbleSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
        }

        @Test
        public void testBubbleSort2() {
            Integer[] input = {1, 2, 3};
            Integer[] expected = {1, 2, 3};

            bubbleSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
        }

        @Test
        public void testBubbleSort3() {
            Integer[] input = {3, 2, 1};
            Integer[] expected = {1, 2, 3};

            bubbleSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
        }

        @Test
        public void testBubbleSort4() {
            Integer[] input = {3, 3, 1};
            Integer[] expected = {1, 3, 3};

            bubbleSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input);
        }

        @Test
        public void testBubbleSort5() {
            Integer[] input = {-1, 2, 1};
            Integer[] expected = {-1, 1, 2};

            bubbleSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input);
        }

        @Test
        public void testBubbleSort6() {
            Integer[] input = {};
            Integer[] expected = {};

            bubbleSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input);
        }
    }


    @Nested
    class InsertionSortTests {
        @Test
        public void testInsertionSort1() {
            Integer[] input = {3, 2, 4};
            Integer[] expected = {2, 3, 4};

            insertionSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input);
        }

        @Test
        public void testInsertionSort2() {
            Integer[] input = {1, 2, 3};
            Integer[] expected = {1, 2, 3};

            insertionSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
        }

        @Test
        public void testInsertionSort3() {
            Integer[] input = {3, 2, 1};
            Integer[] expected = {1, 2, 3};

            insertionSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
        }

        @Test
        public void testInsertionSort4() {
            Integer[] input = {3, 3, 1};
            Integer[] expected = {1, 3, 3};

            insertionSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input);
        }

        @Test
        public void testInsertionSort5() {
            Integer[] input = {-1, 2, 1};
            Integer[] expected = {-1, 1, 2};

            insertionSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input);
        }

        @Test
        public void testInsertionSort6() {
            Integer[] input = {};
            Integer[] expected = {};

            insertionSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input);
        }
    }

    @Nested
    class SelectionSortTests {
        @Test
        public void testSelectionSort1() {
            Integer[] input = {3, 2, 4};
            Integer[] expected = {2, 3, 4};

            selectionSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
        }

        @Test
        public void testSelectionSort2() {
            Integer[] input = {1, 2, 3};
            Integer[] expected = {1, 2, 3};

            selectionSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
        }

        @Test
        public void testSelectionSort3() {
            Integer[] input = {3, 2, 1};
            Integer[] expected = {1, 2, 3};

            selectionSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
        }

        @Test
        public void testSelectionSort4() {
            Integer[] input = {3, 3, 1};
            Integer[] expected = {1, 3, 3};

            selectionSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input);
        }

        @Test
        public void testSelectionSort5() {
            Integer[] input = {-1, 2, 1};
            Integer[] expected = {-1, 1, 2};

            selectionSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input);
        }

        @Test
        public void testSelectionSort6() {
            Integer[] input = {};
            Integer[] expected = {};

            selectionSort(input, Comparator.naturalOrder());
            Assertions.assertArrayEquals(expected, input);
        }
    }
}
