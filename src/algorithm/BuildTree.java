package algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 */
public class BuildTree {
    //从前序遍历确定根节点，从中序遍历确定长度，

    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++){
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);

    }

    //根节点在前序遍历的索引 root 、子树在中序遍历的左边界 left 、子树在中序遍历的右边界 right 。
    private TreeNode recur(int root, int left, int right) {
        // 递归终止
        if (left > right){
            return null;
        }
        // 建立根节点
        TreeNode node = new TreeNode(preorder[root]);
        // 划分根节点、左子树、右子树
        int i = dic.get(preorder[root]);
        node.left = recur(root + 1, left, i-1);
        // `i - left + root + 1`含义为 `根节点索引 + 左子树长度 + 1`
        node.right = recur(root + i - left + 1, i + 1, right);
        return node;
    }

/*    作者：Krahets
    链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/2361558/105-cong-qian-xu-yu-zhong-xu-bian-li-xu-4lvkz/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
