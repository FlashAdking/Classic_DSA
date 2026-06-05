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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];

        diameter(root , ans);

        return ans[0];
    }

    public int diameter( TreeNode root , int[] ans ){
        if( root == null) return 0;

        int left = diameter(root.left , ans);
        int right = diameter(root.right , ans);

        ans[0] = Math.max(ans[0] , left + right);

        return Math.max(left , right)+1;
    }
}
