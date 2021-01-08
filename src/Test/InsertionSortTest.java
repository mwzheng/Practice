package Test;

import SortingAndSearching.InsertionSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void sort() {
        String[] array = new String[] {"world", "hello"};
        InsertionSort.sort(array);
        assertEquals("[hello, world]", Arrays.toString(array));

        String[] array2 = new String[] {"foobar", "world", "hello", "goodbye", "foo"};
        InsertionSort.sort(array2);
        assertEquals("[foo, foobar, goodbye, hello, world]", Arrays.toString(array2));
    }
}