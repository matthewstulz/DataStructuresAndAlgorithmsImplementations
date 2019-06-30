package datastructures.BST;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    private TreeNode root;
    private TreeNode treeNodeParent;

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
        treeNodeParent = root;
        if (key < root.getKey()) {
            return searchRecursive(root.left, key);
        }
        return searchRecursive(root.right, key);
    }

    public TreeNode searchIterative(int key) {
        if (root == null) return null;
        TreeNode current = root;
        while (current.getKey() != key) {
            if (key < current.getKey()) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) return null;
        }
        return current;
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
    Remove process (Hibbard's deletion)
    1. Find the node that we wish to remove (temp)
    2. Find the successor node (node in the right subtree that has the minimum value
    3. Replace the content of temp of that with the successor node
    4. Delete the successor node
     */
    public void remove(int key) {
        TreeNode temp, parent = root, successor;
        temp = searchRecursive(key);
        if (temp == null) return;
        /* Hibbard's deletion */
        // The node has no children
        if (temp.left == null && temp.right == null) {
            if (temp == root) root = null;
            parent = treeNodeParent;
            if (parent.left == temp) parent.left = null;
            else parent.right = null;
        }
        // The node has one child
        else if (temp.right == null) {
            if (temp == root) root = null;
            parent = treeNodeParent;
            if (parent.left == temp) parent.left = temp.left;
            else parent.right = temp.left;
        }
        else if (temp.left == null) {
            if (temp == root) root = null;
            parent = treeNodeParent;
            if (parent.left == temp) parent.left = temp.right;
            else parent.right = temp.right;
        }
        // The node has 2 children
        else {
            // The right node of temp is the successor
            if (temp.right.left == null) {
                temp.setKey(temp.right.getKey());
                temp.right = temp.right.right;
            } else {
                successor = temp.right;
                TreeNode successorParent = temp;
                while (successor.left != null) {
                    successorParent = successor;
                    successor = successor.left;
                }
                temp.setKey(successor.getKey());
                successorParent.left = successor.right;
            }
        }
    }
}
