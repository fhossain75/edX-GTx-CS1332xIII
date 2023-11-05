package tests;
import java.util.Arrays;
import org.junit.jupiter.api.*;
import static divide_and_conquer_sort.Sorting.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideAndConquerSortsTests {

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
    class MergeSortTests {

        @Test
        public void testSortedArray() {
            Integer[] input = {1, 2, 3};
            Integer[] expected = {1, 2, 3};
            int expectedCount = (int) (input.length * (Math.log(input.length) / Math.log(2)));
            mergeSort(input, comparator);

            // Sort Test
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
            // Comparison Count Test
            assertEquals(expectedCount, comparator.getCount());
        }

        @Test
        public void testReverseSortedArray() {
            Integer[] input = {5, 4, 3, 2, 1};
            Integer[] expected = {1, 2, 3, 4, 5};
            int expectedCount = (int) (input.length * (Math.log(input.length) / Math.log(2)));
            mergeSort(input, comparator);

            // Sort Test
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
            // Comparison Count Test
            assertEquals(expectedCount, comparator.getCount());
        }

        @Test
        public void testAllSameElementsArray() {
            Integer[] input = {4, 4, 4};
            Integer[] expected = {4, 4, 4};
            int expectedCount = (int) (input.length * (Math.log(input.length) / Math.log(2)));
            mergeSort(input, comparator);

            // Sort Test
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
            // Comparison Count Test
            assertEquals(expectedCount, comparator.getCount());
        }

        @Test
        public void testDuplicateElementsArray() {
            Integer[] input = {5, 4, 3, 2, 1, 1};
            Integer[] expected = {1, 1, 2, 3, 4, 5};
            int expectedCount = (int) (input.length * (Math.log(input.length) / Math.log(2)));
            mergeSort(input, comparator);

            // Sort Test
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
            // Comparison Count Test
            assertEquals(expectedCount, comparator.getCount());
        }

        @Test
        public void testEmptyArray() {
            Integer[] input = {};
            Integer[] expected = {};
            int expectedCount = (int) (input.length * (Math.log(input.length) / Math.log(2)));
            mergeSort(input, comparator);

            // Sort Test
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
            // Comparison Count Test
            assertEquals(expectedCount, comparator.getCount());
        }

        @Test
        public void testNegativeElementArray() {
            Integer[] input = {-1, 2, 1};
            Integer[] expected = {-1, 1, 2};
            int expectedCount = (int) (input.length * (Math.log(input.length) / Math.log(2)));
            mergeSort(input, comparator);

            // Sort Test
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
            // Comparison Count Test
            assertEquals(expectedCount, comparator.getCount());
        }

        @Test
        public void testSingleElementArray() {
            Integer[] input = {1};
            Integer[] expected = {1};
            int expectedCount = (int) (input.length * (Math.log(input.length) / Math.log(2)));
            mergeSort(input, comparator);

            // Sort Test
            Assertions.assertArrayEquals(expected, input, "Actual: " + Arrays.toString(input) + ", Expected: " + Arrays.toString(expected));
            // Comparison Count Test
            assertEquals(expectedCount, comparator.getCount());
        }
    }
}