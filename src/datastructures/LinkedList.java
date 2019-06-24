package datastructures;

public class LinkedList {

    class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public boolean contains(int data) {
        if (isEmpty()) return false;
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Node element() { return head; }

    public int size() {
        if (isEmpty()) return 0;
        Node current = head;
        int size = 1;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void clear() { head = null; }

    public Node removeNode(int data) {
        Node current = head;
        Node previous = head;
        while (current.data != data) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    public void display() {
        if (isEmpty()) System.out.println("List is empty.");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}