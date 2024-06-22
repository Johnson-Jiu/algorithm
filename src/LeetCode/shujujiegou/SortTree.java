package LeetCode.shujujiegou;

import java.util.Stack;

public class SortTree {

      public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
      }

    public void mid(TreeNode root){
        Stack<TreeNode> sta = new Stack<>();
        while(!sta.isEmpty() || root != null){
            if(root != null){
                sta.push(root);
                root = root.left;
            }else{
                root = sta.pop();
                //list2.add(root.val);
                root = root.right;
            }
        }
    }
    public void  first(TreeNode root){
        Stack<TreeNode> sta = new Stack<>();
        while(!sta.isEmpty() || root != null){
            if(root != null){
                sta.push(root);
               // list1.add(root.val);
                root = root.left;
            }else{
                root = sta.pop();
                root = root.right;
            }
        }
    }

    private static void postOrder(TreeNode root) {
        Stack<TreeNode> src = new Stack<TreeNode>();
        Stack<TreeNode> res = new Stack<TreeNode>();
        src.push(root);
        while(!src.isEmpty()){
            TreeNode p = src.pop();
            res.push(p);
            if(p.left != null){
                src.push(p.left);
            }
            if(p.right != null){
                src.push(p.right);
            }
        }
        //输出最终后序遍历的结果
        while(!res.isEmpty()){
            System.out.print(res.pop().val + " ");
        }
    }

}
