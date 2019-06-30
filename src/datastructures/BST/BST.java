package datastructures.BST;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    private TreeNode root;

    public BST() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    // Recursive insert
    public TreeNode insertRecursive(TreeNode root, int key) {
        TreeNode newNode = new TreeNode(key);
        if (root == null) root = newNode;
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

    public TreeNode searchRucursive(TreeNode root, int key) {
        if (root == null || root.getKey() == key) return root;
        if (key < root.getKey()) {
            return searchRucursive(root.left, key);
        }
        return searchRucursive(root.right, key);
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

    public void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.getKey() + " ");
            inOrderTraversal(root.right);
        }
    }

    public void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.getKey() + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.getKey() + " ");
        }
    }

    public void printLevelOrder() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.getKey() + " ");
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
    }
}
