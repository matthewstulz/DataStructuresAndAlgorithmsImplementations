package datastructures;

public class StackLinkedList<V> {

    static private class StackNode<V> {

        private V value;
        private StackNode next;

        StackNode(V value) {
            this.value = value;
        }
    }

    private StackNode head;

    public StackLinkedList() { }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int value) {
        StackNode newNode = new StackNode<>(value);
        if (head == null) head = newNode;
        StackNode temp = head;
        head = newNode;
        newNode.next = temp;
    }

    public V pop() {
        StackNode temp = head;
        head = head.next;
        return (V) temp.value;
    }

    public Object peek() {
        return head.value;
    }

    public int search(int value) {
        if (head == null) return -1;
        int i = 0;
        while (head != null) {
            if (head.value.equals(value)) return i + 1;
            else head = head.next;
        }
        return -1;
    }
}