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
    public int countDominantNodes(TreeNode root) {
        int[] ans = new int[1];
        
        countDomi( root , ans);
        return ans[0];
    }

    public int countDomi(TreeNode root , int[] ans){
        if( root == null) return 0;

        int left = countDomi(root.left , ans);
        int right = countDomi( root.right , ans);

        // dominant node
        int max = Math.max(root.val , Math.max( left , right ));

        if( root.val == max) ans[0]++;
        
        return max;
    }
}



















