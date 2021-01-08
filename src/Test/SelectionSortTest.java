package Test;

import SortingAndSearching.SelectionSort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void sort() {
        int[] array = new int[]{5, 1, 3, 4, 6, 9};
        SelectionSort.sort(array);
        assertEquals("[1, 3, 4, 5, 6, 9]", Arrays.toString(array));

        int[] array2 = new int[]{-100, 32, -3, 72, 6, 0};
        SelectionSort.sort(array2);
        assertEquals("[-100, -3, 0, 6, 32, 72]", Arrays.toString(array2));
    }
}