package algorithm;

import org.junit.Test;

import java.util.*;


public class LeetCode {


      public class TreeNode {
          int val;
         TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    /**
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[0]){
                index = i;
            }
        }
        node.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        node.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));

        return node;
    }

    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n,n,"");
        return res;
    }

    private void dfs(int n,int m,String s){
        if(n == 0 && m == 0){
            res.add(s);
            return;
        }
        if(n > 0){
            dfs(n-1,m,s + "(");
        }
        if(m > n){
            dfs(n,m-1,s + ")");
        }

    }

    @Test
    public void test01(){
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
    public int[] nextPermutation(int[] nums) {
        if (nums.length == 1 || nums.length == 0){
            return nums;
        }
        boolean flag = true;
        int index = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > nums[i-1]){
                index = i - 1;
                for(int j = nums.length - 1; j > 0;j--){
                    if(nums[j] > nums[index]){
                        swap(nums,index,j);
                        flag = false;
                        break;
                    }
                }
                break;
            }
        }
        if (flag){
            Arrays.sort(nums);
        }else {
            Arrays.sort(nums,index + 1,nums.length);
        }
        return nums;
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


    public int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if(stack.isEmpty()){
                stack.push(nums[i]);
            }else{
                if(stack.peek() == nums[i]){
                    stack.pop();
                }else{
                    stack.push(nums[i]);
                }
            }
        }
        return stack.pop();
    }
}
