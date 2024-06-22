package LeetCode.tree;

import org.junit.Test;

public class MergeTrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    /**
     * 输入:
     * 	Tree 1                     Tree 2
     *           1                         2
     *          / \                       / \
     *         3   2                     1   3
     *        /                           \   \
     *       5                             4   7
     * 输出:
     * 合并后的树:
     * 	     3
     * 	    / \
     * 	   4   5
     * 	  / \   \
     * 	 5   4   7
     *[1,3,2,5]
     * [2,1,3,null,4,null,7]
     * [3,4,5,5,4,null,7]
     * @param root1
     * @param root2
     * @return
     * [3,4,5,5,4,null,7]
     */
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return root2;
            }
            if (root2 == null) {
                return root1;
            }
            int i = root1.val;
            int j = root2.val;
            TreeNode merged = new TreeNode(i+j);
            merged.left = mergeTrees(root1.left,root2.left);
            merged.right = mergeTrees(root1.right, root2.right);
            return merged;
         }

         @Test
        public void test(){
             TreeNode treeNode1 = new TreeNode(1,new TreeNode(3,new TreeNode(5,null,null),null),new TreeNode(2,null,null));
             TreeNode treeNode2 = new TreeNode(2
                     ,new TreeNode(1,null,new TreeNode(4,null,null))
                     ,new TreeNode(3,null,new TreeNode(7,null,null)));
             mergeTrees(treeNode1,treeNode2);
        }
}
