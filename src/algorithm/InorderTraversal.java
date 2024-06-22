package algorithm;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        res.addAll(inorderTraversal(root.left));
        res.addAll(inorderTraversal(root.right));
        return res;
    }
}
