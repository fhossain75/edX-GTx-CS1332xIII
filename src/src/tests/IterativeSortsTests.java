package tests;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.*;
import static iterative_sorts.Sorting.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IterativeSortsTests {

    private static CountingComparator<Integer> comparator;

    @BeforeAll
    public static void setUp() {
        comparator = new CountingComparator<>(Integer::compareTo);
    }

    @AfterEach
    public void tearDown() {
        comparator.resetCount();
    }

    @Nested
    class BubbleSortTests {

        @Test
        public void testSortedArray() {
            Integer[] input = {1, 2, 3};
            Integer[] expected = {1, 2, 3};
            int expectedCount = input.length - 1;
            bubbleSort(input, comparator);

            // Sort Test
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
            // Comparison Count Test
            assertEquals(expectedCount, comparator.getCount());
        }

        @Test
        public void testReverseSortedArray() {
            Integer[] input = {5, 4, 3, 2, 1};
            Integer[] expected = {1, 2, 3, 4, 5};
            int expectedCount = input.length * (input.length - 1) / 2; // The number of comparisons will be n * (n-1) / 2 for a reversed array of size n
            bubbleSort(input, comparator);

            // Sort Test
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
            // Comparison Count Test
            assertEquals(expectedCount, comparator.getCount());
        }

        @Test
        public void testAllSameElementsArray() {
            Integer[] input = {4, 4, 4};
            Integer[] expected = {4, 4, 4};
            int expectedCount = input.length - 1;
            bubbleSort(input, comparator);

            // Sort Test
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
            // Comparison Count Test
            assertEquals(expectedCount, comparator.getCount());
        }

        @Test
        public void testDuplicateElementsArray() {
            Integer[] input = {5, 4, 3, 2, 1, 1};
            Integer[] expected = {1, 1, 2, 3, 4, 5};
            int expectedCount = input.length * (input.length - 1) / 2;
            bubbleSort(input, comparator);

            // Sort Test
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
            // Comparison Count Test
            assertEquals(expectedCount, comparator.getCount());
        }

        @Test
        public void testEmptyArray() {
            Integer[] input = {};
            Integer[] expected = {};
            int expectedCount = 0;
            bubbleSort(input, comparator);

            // Sort Test
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
            // Comparison Count Test
            assertEquals(expectedCount, comparator.getCount());
        }

        @Test
        public void testNegativeElementArray() {
            Integer[] input = {-1, 2, 1};
            Integer[] expected = {-1, 1, 2};
            int expectedCount = input.length * (input.length - 1) / 2;
            bubbleSort(input, comparator);

            // Sort Test
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
            // Comparison Count Test
            assertEquals(expectedCount, comparator.getCount());
    }

        @Test
        public void testSingleElementArray() {
            Integer[] input = {1};
            Integer[] expected = {1};
            int expectedCount = 0;
            bubbleSort(input, comparator);

            // Sort Test
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
            // Comparison Count Test
            assertEquals(expectedCount, comparator.getCount());
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
