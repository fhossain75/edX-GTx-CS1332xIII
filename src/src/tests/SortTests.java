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
        // do something
    }
}
