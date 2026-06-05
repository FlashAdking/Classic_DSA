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
    public boolean isBalanced(TreeNode root) {
        return isBalancedTree(root) != -1;    
    }

    public int isBalancedTree(TreeNode root){
        if( root == null ) return 0;

        int left = isBalancedTree(root.left);
        int right = isBalancedTree(root.right);

        if( left == -1 || right == -1) return -1;

        if( Math.abs(left - right) > 1) return -1;

        return Math.max(left , right) + 1;
    }

}
