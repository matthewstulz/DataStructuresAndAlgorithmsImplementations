package datastructures.BST;

public class TreeNode {

    TreeNode left, right;
    private int key;


    public TreeNode(int key) {
        this.key = key;
        left = right = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
}
