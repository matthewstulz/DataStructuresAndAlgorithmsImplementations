package datastructures.BST;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    private TreeNode root;

    public BST() {
        root = null;
    }

    public void insertRecursive(int key) { root = insertRecursive(root, key); }

    // Recursive insert
    private TreeNode insertRecursive(TreeNode root, int key) {
        if (root == null) return new TreeNode(key);
        if (key < root.getKey()) {
            root.left = insertRecursive(root.left, key);
        } else if (key > root.getKey()) {
            root.right = insertRecursive(root.right, key);
        }
        return root;
    }

    // Iterative insert
    public void insertIterative(int key) {
        TreeNode newNode = new TreeNode(key);
        if (root == null) root = newNode;
        else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (key < current.getKey()) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public TreeNode searchRecursive(int key) { return searchRecursive(root, key); }

    private TreeNode searchRecursive(TreeNode root, int key) {
        if (root == null || root.getKey() == key) return root;
        if (key < root.getKey()) {
            return searchRecursive(root.left, key);
        }
        return searchRecursive(root.right, key);
    }

    public boolean searchIterative(int key) {
        if (root == null) return false;
        TreeNode current = root;
        while (current.getKey() != key) {
            if (key < current.getKey()) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) return false;
        }
        return true;
    }

    public void inOrderTraversal() { inOrderTraversal(root); }
    public void preOrderTraversal() { preOrderTraversal(root); }
    public void postOrderTraversal() { postOrderTraversal(root); }
    public void printLevelOrder() { printLevelOrder(root); }


    private void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.getKey() + " ");
            inOrderTraversal(root.right);
        }
    }

    private void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.getKey() + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    private void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.getKey() + " ");
        }
    }

    private void printLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                assert current != null;
                System.out.print(current.getKey() + " ");
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            System.out.println();
        }
    }

    /*
    Remove process
    1. Find the node that we wish to remove (temp)
    2. Find the successor node (node int he right subtree that has the minimum value
    3. Replace the content of temp of that with the successor node
    4. Delete the successor node
     */
}
