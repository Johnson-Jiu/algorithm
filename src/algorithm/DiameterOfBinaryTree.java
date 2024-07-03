package algorithm;

import org.junit.Test;

/**
 * 二叉树的直径
 *
 */
public class DiameterOfBinaryTree {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return res;

    }

    private int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        ////将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        res = Math.max(res, leftDepth + rightDepth);
        //返回节点深度
        return Math.max(leftDepth, rightDepth) + 1;
    }

    @Test
    public void test(){
        TreeNode node = new TreeNode(1,new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        diameterOfBinaryTree(node);
    }
}
