package algorithm;

import org.junit.Test;

/**
 * 验证二叉搜索树
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return getBSTFlag(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean getBSTFlag(TreeNode root, Long left, Long right) {
        if(root == null){
            return true;
        }
        Long val = (long)root.val;
        if(val <= left || val >= right){
            return false;
        }


        return getBSTFlag(root.left, left, val) && getBSTFlag(root.right, val, right);
    }

    //中序遍历
  /*
   class Solution {
        public boolean isValidBST(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            double inorder = -Double.MAX_VALUE;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
                if (root.val <= inorder) {
                    return false;
                }
                inorder = root.val;
                root = root.right;
            }
            return true;
        }
    }

    作者：力扣官方题解
    链接：https://leetcode.cn/problems/validate-binary-search-tree/solutions/230256/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    @Test
    public void test(){
        //[5,4,6,null,null,3,7]
        TreeNode treeNode = new TreeNode(5);

        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(6);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(7);
        isValidBST(treeNode);
    }
}
