package algorithm;

/**
 * 二叉树展开为链表
 */
public class Flatten {

    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        // 将左子树展开为单链表
        flatten(root.left);
        // 将右子树展开为单链表
        flatten(root.right);
        // 暂存右子树
        TreeNode temp = root.right;
        // 左子树接到根的右侧
        root.right = root.left;
        // 左子树置空
        root.left = null;
        // 再接上右子树
        while(root.right != null) {
            root = root.right;
        }
        root.right = temp;

/*        作者：好好刷题
        链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solutions/357228/0mszhan-sheng-100yong-hu-zhu-shi-hen-xiang-xi-xi-w/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    }


}
