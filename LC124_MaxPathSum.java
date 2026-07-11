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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        
        res[0] = -1002;
        MaxPath(root , res);
        return res[0];
    }

    public int MaxPath(TreeNode root , int[] store){
        if( root == null) return 0;

        int left = Math.max( 0 , MaxPath(root.left , store));
        int right = Math.max( 0 , MaxPath(root.right , store));

        store[0] = Math.max( store[0], root.val + left + right);

        return root.val + Math.max(left , right);
    }
}
