package datastructures;

import java.math.BigInteger;

public class HashTableSeparateChainingArray {

    class HashNode {
        private Integer key;
        private String value;
        HashNode next;

        HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashNode[] bucketArray;
    private int capacity;
    private int size;

    public HashTableSeparateChainingArray(int capacity) {
        bucketArray = new HashNode[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }

    private int getBucketIndex(Integer key) {
        return key.hashCode() % capacity;
    }

    public void add(Integer key, String value) {
        // Get bucket index of generated node
        int bucketIndex = getBucketIndex(key);
        // Temp head node used to traverse through chain
        HashNode head = bucketArray[bucketIndex];
        // Check if key exists already
        while (head != null) {
            // If it does exist,
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        // Check load factor and resize hashTable if threshold is greater than 70%
        if (size >= 0.7 * capacity) {
            resize();
        }
        // Generate node to be added and point it to the front of the bucket
        HashNode newNode = new HashNode(key, value);
        newNode.next = bucketArray[bucketIndex];
        bucketArray[bucketIndex] = newNode;
        size++;
    }

    // Used to get next prime value for capacity of HashTable.
    private int generateNextPrimeCapacity(int currCapacity) {
        BigInteger bigInteger = new BigInteger(String.valueOf(currCapacity));
        capacity = Integer.parseInt(bigInteger.nextProbablePrime().toString());
        return capacity;
    }

    private void resize() {
        HashNode[] newTable = new HashNode[generateNextPrimeCapacity(capacity)];
        for (HashNode hashNode : bucketArray) {
            HashNode head = hashNode;
            while (head != null) {
                HashNode next = head.next;
                int bucketIndex = getBucketIndex(head.key);
                head.next = newTable[bucketIndex];
                newTable[bucketIndex] = head;
                head = next;
            }
        }
        bucketArray = newTable;
    }

    public String get(int key) {
        int bucketIndex = getBucketIndex(key);
        // Temp head node used to traverse through chain
        HashNode head = bucketArray[bucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public String remove(int key) {
        int bucketIndex = getBucketIndex(key);
        // Bucket is null so the key doesn't exist
        if (bucketArray[bucketIndex] == null) return null;
        // The head of the bucket is the node to remove
        if (bucketArray[bucketIndex].key.equals(key)) {
            String value = bucketArray[bucketIndex].value;
            bucketArray[bucketIndex] = bucketArray[bucketIndex].next;
            size--;
            return value;
        }
        // Keeping two pointers, find the node that we need to remove
        HashNode prev = bucketArray[bucketIndex];
        HashNode head = prev.next;
        while (head != null && !head.key.equals(key)) {
            prev = head;
            head = head.next;
        }
        // We found our node with the key value we were looking for
        if (head != null) {
            String value = head.value;
            prev.next = head.next;
            size--;
            return value;
        }
        return null;
    }

    public boolean containsKey(int key) {
        int bucketIndex = getBucketIndex(key);
        HashNode head = bucketArray[bucketIndex];
        while (head != null) {
            if (head.key.equals(key))
                return true;
            head = head.next;
        }
        return false;
    }
}
