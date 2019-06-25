package sortingalgorithms;

public class QuickSort {

    // Time complexity of O(n log n)
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int wall = (low - 1);
        for (int current = low; current < high; current++) {
            if (array[current] <= pivot) {
                wall++;
                swap(array, wall, current);
            }
        }
        swap(array, wall + 1, high);
        return wall + 1;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void printArray(int[] array) {
        for (int i:array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
