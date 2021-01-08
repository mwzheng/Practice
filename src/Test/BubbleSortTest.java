package Test;

import SortingAndSearching.BubbleSort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sort() {
        assertNull(BubbleSort.sort(null));

        String[] arrayUnsorted = new String[]{"zebra", "kangaroo", "koala", "alligator", "shark", "cow", "moose"};
        assertEquals("[alligator, cow, kangaroo, koala, moose, shark, zebra]", Arrays.toString(BubbleSort.sort(arrayUnsorted)));

        arrayUnsorted = new String[]{"apple", "banana", "corn"};
        assertEquals("[apple, banana, corn]", Arrays.toString(BubbleSort.sort(arrayUnsorted)));

        arrayUnsorted = new String[]{"c", "d", "y", "p", "r", "p", "b", "q", "m", "a"};
        assertEquals("[a, b, c, d, m, p, p, q, r, y]", Arrays.toString(BubbleSort.sort(arrayUnsorted)));
    }
}