package Test;

import SortingAndSearching.BinarySearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    @Test
    void search() {
        String[] array = new String[0];
        assertEquals(-1, BinarySearch.search(array, ""));

        array = new String[]{"apples", "bananas", "grapes", "mangoes", "strawberries", "watermelon", "zucchinis"};
        assertEquals(-1, BinarySearch.search(array, "zebra"));
        assertEquals(-1, BinarySearch.search(array, "ace"));

        assertEquals(0, BinarySearch.search(array, "apples"));
        assertEquals(6, BinarySearch.search(array, "zucchinis"));
    }

    @Test
    void recursiveSearch() {
        String[] array = new String[0];
        assertEquals(-1, BinarySearch.search(array, ""));

        array = new String[]{"apples", "bananas", "grapes", "mangoes", "strawberries", "watermelon", "zucchinis"};
        assertEquals(-1, BinarySearch.recursiveSearch(array, "zebra", 0, array.length));
        assertEquals(-1, BinarySearch.recursiveSearch(array, "ace", 0 , array.length));

        assertEquals(0, BinarySearch.recursiveSearch(array, "apples", 0 , array.length));
        assertEquals(6, BinarySearch.recursiveSearch(array, "zucchinis", 0, array.length));
    }
}