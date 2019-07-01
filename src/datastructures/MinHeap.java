package datastructures;

public class MinHeap {

    private int[] heap;
    private int size;
    private int capacity;

    private static final int ROOT = 1;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[this.capacity + 1];
    }

    private int parent(int pos) { return pos / 2; }
    private int leftChild(int pos) { return 2 * pos; }
    private int rightChild(int pos) { return (2 * pos) + 1; }
    private boolean isLeaf(int pos) { return pos >= (size / 2) && pos <= size; }
    public int getMin() { return heap[ROOT]; }

    private void swap(int pos1, int pos2) {
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    public void insert(int element) {
        if (size >= capacity) return;
        heap[++size] = element;
        // Bubble up the element that was just added to the heap if its smaller than its parent
        int current = size;
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Bubble down to place latest added element to maintain min heap property
    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public int extractMin() {
        int popped = heap[ROOT];
        heap[ROOT] = heap[size--];
        minHeapify(ROOT);
        return popped;
    }

    public void inOrderPrint() {
        for (int i = 1; i < size + 1; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}
