/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
       Stack<TreeNode[]> stack = new Stack<>();

       stack.add(new TreeNode[]{p, q});

       while(!stack.isEmpty()){

        TreeNode[] current = stack.pop();

        TreeNode left = current[0];
        TreeNode right = current[1];

        if(left == null && right == null){
            continue;
        }

        if(left == null || right == null || left.val != right.val){
            return false;
        }

        stack.add(new TreeNode[]{left.left, right.left});
        stack.add(new TreeNode[]{left.right, right.right});

       } 

       return true; 
    }

}
