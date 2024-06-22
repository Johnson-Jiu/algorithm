package LeetCode.链表;

import org.junit.Test;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Flatten {
    @Test
    public void test(){
        TreeNode newRoot = new TreeNode(1,new TreeNode(2,new TreeNode(3,null,null),new TreeNode(4,null,null))
                ,new TreeNode(5,null,new TreeNode(6,null,null)));
        change(newRoot);
    }
    public TreeNode flatten(TreeNode root) {
        TreeNode newRoot = new TreeNode(0,null,null);
        TreeNode node = newRoot;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                newRoot.right = new TreeNode(root.val,null,null);
                newRoot = newRoot.right;
                root = root.left;
            }else {
                root = stack.pop();
                root = root.right;
            }
        }
        root = node.right;
        return root;
    }

    public TreeNode change(TreeNode root) {
        if(root != null) {
            TreeNode right = root.right;
            TreeNode leftTail = change(root.left);
            TreeNode rightTail = change(root.right);

            if(root.left != null) {
                root.right = root.left;
                root.left = null;
                root = leftTail;
            }
            if(right != null) {
                root.right = right;
                root = rightTail;
            }
        }
        return root;
    }
}
