package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();

            //int i = 0; i < queue.size(); i++  这样子size 会被改变，导致遍历出错
            for(int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                if(poll == null){
                    continue;
                }
                temp.add(poll.val);
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
