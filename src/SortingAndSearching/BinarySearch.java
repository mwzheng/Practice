package SortingAndSearching;

/**
 * Class contains single function for binary search.
 **/
public class BinarySearch {
    /**
     * Takes in a sorted array of Strings returns the index
     * of the itemToSearchFor. If it doesn't exist return -1;
     **/
    public static int search(String[] arr, String itemToSearchFor) {
        if (arr == null || arr.length == 0)
            return -1;

        int midIndex, leftIndex = 0, rightIndex = arr.length - 1;

        while (leftIndex <= rightIndex) {
            midIndex = leftIndex + (rightIndex - leftIndex) / 2;

            if (arr[midIndex].equals(itemToSearchFor)) // Mid is the item you're looking for
                return midIndex;

            if (arr[midIndex].compareTo(itemToSearchFor) < 0) { // Search right of array
                leftIndex = midIndex + 1;
            } else { // Search left of array
                rightIndex = midIndex - 1;
            }
        }

        return -1; // Item not in array
    }

    /**
     * Recursive version of binary search. Returns index of itemToSearchFor, or -1 if it's not found.
     **/
    public static int recursiveSearch(String[] arr, String itemToSearchFor, int leftIndex, int rightIndex) {
        if (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;

            if (arr[midIndex].equals(itemToSearchFor))
                return  midIndex;

            if (arr[midIndex].compareTo(itemToSearchFor) < 0) { // Search right side
                return recursiveSearch(arr, itemToSearchFor, midIndex + 1, rightIndex);
            } else { // Search left size
                return recursiveSearch(arr, itemToSearchFor, leftIndex, midIndex - 1);
            }
        }

        return -1;
    }
}
