package sortingalgorithms;

public class MergeSort {

    // Time complexity of O(n log n)
    public static void mergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int midpoint = leftIndex + (rightIndex-leftIndex) / 2;

            mergeSort(array, leftIndex, midpoint);
            mergeSort(array, midpoint + 1, rightIndex);
            merge(array, leftIndex, midpoint, rightIndex);
        }
    }

    private static void merge(int[] array, int leftIndex, int midpoint, int rightIndex) {
        // Pointers to keep track of position
        int leftPointer, rightPointer, resultPointer;

        // Creates left and right arrays and copies the values from our array to be sorted.
        int[] left = new int[midpoint - leftIndex + 1];
        int[] right = new int[rightIndex - midpoint];

        for (leftPointer = 0; leftPointer < left.length; leftPointer++)
            left[leftPointer] = array[leftIndex + leftPointer];
        for (rightPointer = 0; rightPointer < right.length; rightPointer++)
            right[rightPointer] = array[midpoint + 1 + rightPointer];

        leftPointer = rightPointer = 0;
        resultPointer = leftIndex;

        // While there are still elements in either right or left arrays.
        while (leftPointer < left.length && rightPointer < right.length) {
            if (left[leftPointer] <= right[rightPointer]) {
                array[resultPointer++] = left[leftPointer++];
            } else {
                array[resultPointer++] = right[rightPointer++];
            }
        }

        // While there are elements still left in left array.
        while (leftPointer < left.length) {
            array[resultPointer++] = left[leftPointer++];
        }

        // While there are elements still left in right array.
        while (rightPointer < right.length) {
            array[resultPointer++] = right[rightPointer++];
        }
    }

    public static void printArray(int[] array) {
        for (int i:array) {
            System.out.print(i + " ");
        }
    }
}
