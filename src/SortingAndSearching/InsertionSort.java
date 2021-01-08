package SortingAndSearching;

/**
 * Class contains single function for Insertion sort.
 **/
public class InsertionSort {

    /**
     * Basic Insertion sort.
     **/
    public static void sort(String[] array) {
        if (array == null || array.length == 1)
            return;

        int arrayLength = array.length, swapIndex;

        for (int i = 1; i < arrayLength; i++) {
            String currToSort = array[i];
            swapIndex = i - 1;

            // Shift index over one until you find the correct place to insert at
            while (swapIndex >= 0 && currToSort.compareTo(array[swapIndex]) < 0) {
                array[swapIndex + 1] = array[swapIndex];
                swapIndex -= 1;
            }

            array[swapIndex + 1] = currToSort;
        }
    }
}
