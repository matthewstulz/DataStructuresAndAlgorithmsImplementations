package datastructures;

import java.util.NoSuchElementException;

public class QueueLinkedList<V> {

    public static class QueueNode<V> {

        V value;
        QueueNode next;

        QueueNode(V value) {
            this.value = value;
        }
    }

    private QueueNode head;
    private QueueNode tail;
    private int size;

    public QueueLinkedList() {
        head = tail = null;
        size = 0;
    }

    public int size() { return size; }

    // Add to the tail of the QueueLinkedList
    public void Enqueue(V value) {
        QueueNode newNode = new QueueNode<>(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public V peek() {
        return (V) head.value;
    }

    public V element() throws NoSuchElementException {
        if (size() == 0) throw new NoSuchElementException();
        return (V) head.value;
    }

    // Remove from the head of the QueueLinkedList
    public V Dequeue() throws NoSuchElementException {
        if (size() == 0) throw new NoSuchElementException();
        QueueNode temp = head;
        head = head.next;
        size--;
        return (V) temp.value;
    }

    public V poll() {
        if (size() == 0) return null;
        QueueNode temp = head;
        head = head.next;
        size--;
        return (V) temp.value;
    }

    public boolean contains(V value) {
        QueueNode current = head;
        while (current != null) {
            if (current.value.equals(value)) return true;
            current = current.next;
        }
        return false;
    }
}
