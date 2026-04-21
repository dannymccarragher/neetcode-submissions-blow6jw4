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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null){
            return false; 
        }

        if(isSameTree(root, subRoot)){
            return true; 
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); 
    }

    private boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true; 
        }

        Stack<TreeNode []> stack = new Stack<>();

        stack.add(new TreeNode[]{p, q});

        while(!stack.isEmpty()){
            TreeNode[] curr = stack.pop();
            TreeNode left = curr[0];
            TreeNode right = curr[1];

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
