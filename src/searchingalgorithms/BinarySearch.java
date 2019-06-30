package searchingalgorithms;

public class BinarySearch {

    // Wrapper for recursive method
    public boolean binarySearchRecursive(int[] array, int x) {
        return binarySearchRecursive(array, x, 0, array.length - 1);
    }

    private boolean binarySearchRecursive(int[] array, int x, int left, int right) {
        if (left > right) return false;
        int mid = (left + right) / 2;
        if (array[mid] == x) {
            System.out.println("Element found at index " + mid);
            return true;
        } else if (x < array[mid]) {
            return binarySearchRecursive(array, x, left, mid - 1);
        } else {
            return binarySearchRecursive(array, x, mid + 1, right);
        }
    }

    public boolean binarySearchIterative(int[] array, int x) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (array[mid] == x) {
                System.out.println("Element found at index " + mid);
                return true;
            } else if (x < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
