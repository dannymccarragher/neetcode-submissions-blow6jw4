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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null){
            return 0;
        }

        height(root);

        return diameter;
        
    }

    //height helper function to get the height of the current subtree
    // utilize a global diameter var to track the largest diameter found currently
    // for helper function, return the max height of left vs right which will then be passed to the parent node

    public int height(TreeNode root){
        //base case
        if(root == null){
            return 0;
        }

        // recurse left nodes to find left length, then same for right
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
