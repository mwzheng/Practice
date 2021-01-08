package SortingAndSearching;

/**
 * Class contains single function for selection sort.
 **/
public class SelectionSort {

    /**
     * Simple selection sort
     **/
    public static void sort(int[] array) {
        if (array == null)
            return;

        int arrayLength = array.length, minIndex;

        for (int i = 0; i < arrayLength; i++) {
            minIndex = i;

            for (int ii = i + 1; ii < arrayLength; ii++) { // Search unsorted portion for next min
                if (array[minIndex] > array[ii]) // Found new min
                    minIndex = ii;
            }

            // Swap curr index (i) with the next smallest
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
