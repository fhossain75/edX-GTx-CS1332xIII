package tests;
import java.util.Comparator;

// Custom comparator class with default features plus ability to count number of comparisons

public class CountingComparator<T> implements Comparator<T> {
    private final Comparator<T> actualComparator;
    private int count;

    public CountingComparator(Comparator<T> actualComparator) {
        this.actualComparator = actualComparator;
        this.count = 0;
    }

    @Override
    public int compare(T o1, T o2) {
        count++;
        return actualComparator.compare(o1, o2);
    }

    public int getCount() {
        return count;
    }

    public void resetCount() {
        count = 0;
    }
}
