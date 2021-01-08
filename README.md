**Coding Practice**

Practice coding different data structs & algorithms. Included a test for each file.

<br>

Data Structs:
- Singly Linked List
  * Bad if you insert a lot in the middle of the list
  * Search/Delete worst case: O(n) (item last in the list)
  * Search/Delete best case: O(1) (item is the head)
  * Insert to head/tail: O(1)

<br>

Algorithms:
- Binary Search: 
    * Takes in a **sorted** list, and a string to search for.
    * After each iteration, split the current indexes in half and only search the relevant side
    * *Best Case:* O(1) (Search item is at the initial mid index)
    * *Worst Case:* O(log n)
  

- Bubble Sort:
  * Foe each iteration, swap the curr index with next index if curr is larger than next
  * An easy algorithm, but not efficient at all
  * *Best Case:* O(1) (array already sorted)
  * *Average Case:* O(n<sup>2</sup>)
  

- Insertion Sort:
  * Slowly sort the array from left to right one index at a time
  * Takes the next index after sorted half and sorts it
  * *Best Case:* O(1) (Already sorted)
  * *Worst Case:* O(2n) (i iterations + all the swaps necessary to find correct index)
    

- Selection Sort:
  * At each iteration, find the min value and place it in correct index
  * Similar to insertion sort. Both have a sorted and sorted portion.
  * Unlike insertion sort, it takes the smallest value from the unsorted section and sorts it
  * *Average Case:* O(n<sup>2</sup>) 