package SortingAndSearching;

/**
 * Class contains single function for bubble sort.
 **/
public class BubbleSort {

    /**
     * Simple bubble sort for an unsorted array of strings.
     **/
    public static String[] sort(String[] array) {
        if (array == null)
            return null;

        int arrayLength = array.length - 1;
        int nextIndex;

        for (int i = 0; i < arrayLength; i++) {
            for (int ii = 0; ii < arrayLength; ii++) {
                nextIndex = ii + 1;

                if (array[ii].compareTo(array[nextIndex]) > 0) { // Swap
                    String temp = array[ii];
                    array[ii] = array[nextIndex];
                    array[nextIndex] = temp;
                }
            }
        }

        return array;
    }
}
