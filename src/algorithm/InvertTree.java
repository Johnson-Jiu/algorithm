package algorithm;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode treeNode = root.left;
        root.left = root.right;
        root.right = treeNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
