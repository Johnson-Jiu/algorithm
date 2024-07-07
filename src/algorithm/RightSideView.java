package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 二叉树的右视图
 */

public class RightSideView {
    ArrayList<ArrayList<Integer>> record = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        queue.add(root);
        getRecord(root);
        List<Integer> res = new ArrayList<>();
        for (ArrayList<Integer> rec : record) {
            res.add(rec.get(rec.size() - 1));
        }
        return res;
    }

    private void getRecord(TreeNode root) {
        if(root == null){
            return;
        }
        while (!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(node == null){
                    continue;
                }
                temp.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            record.add(temp);
        }
    }
}
