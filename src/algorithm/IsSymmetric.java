package algorithm;

/**
 * 对称二叉树
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return booleanIsSymmetric(root.left, root.right);
    }

    private boolean booleanIsSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return booleanIsSymmetric(left.left, right.right) && booleanIsSymmetric(left.right, right.left);
    }


}
