package tests;
import org.junit.Test;

import java.util.Comparator;

import static iterative_sorts.Sorting.bubbleSort;
import static org.junit.Assert.assertArrayEquals;


public class SortTests {

    @Test
    public void testBubbleSort1() {
        Integer[] input = {3, 2, 4};
        Integer[] expected = {2, 3, 4};

        bubbleSort(input, Comparator.naturalOrder());
        assertArrayEquals(expected, input);
    }

    @Test
    public void testBubbleSort2() {
        Integer[] input = {1, 2, 3};
        Integer[] expected = {1, 2, 3};

        bubbleSort(input, Comparator.naturalOrder());
        assertArrayEquals(expected, input);
    }

    @Test
    public void testBubbleSort3() {
        Integer[] input = {3, 2, 1};
        Integer[] expected = {1, 2, 3};

        bubbleSort(input, Comparator.naturalOrder());
        assertArrayEquals(expected, input);
    }

    @Test
    public void testBubbleSort4() {
        Integer[] input = {3, 3, 1};
        Integer[] expected = {1, 3, 3};

        bubbleSort(input, Comparator.naturalOrder());
        assertArrayEquals(expected, input);
    }

    @Test
    public void testBubbleSort5() {
        Integer[] input = {-1, 2, 1};
        Integer[] expected = {-1, 1, 2};

        bubbleSort(input, Comparator.naturalOrder());
        assertArrayEquals(expected, input);
    }

    @Test
    public void testBubbleSort6() {
        Integer[] input = {};
        Integer[] expected = {};

        bubbleSort(input, Comparator.naturalOrder());
        assertArrayEquals(expected, input);
    }
}
