package algorithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉搜索树中第K小的元素
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            --k;
            root = stack.pop();
            if(k == 0){
                break;
            }
            root = root.right;

        }
        return root.val;
    }



    //递归
/*    ArrayList<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {

        getList(root);
        return list.get(k-1);
    }

    private void getList(TreeNode root) {
        if(root == null){
            return;
        }
        getList(root.left);
        list.add(root.val);
        getList(root.right);
    }*/
}
