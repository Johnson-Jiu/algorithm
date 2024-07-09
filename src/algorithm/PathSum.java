package algorithm;

/**
 * 路径总和 III
 */
public class PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    private int rootSum(TreeNode root, int targetSum) {
        int sum = 0;
        if(root == null){
            return 0;
        }
        if(targetSum == root.val){
            sum++;
        }
        sum += rootSum(root.left, targetSum - root.val);
        sum += rootSum(root.right, targetSum - root.val);
        return sum;
    }
}
