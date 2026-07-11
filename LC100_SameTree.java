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
        return isIdentical(p , q);
    }

    public boolean isIdentical(TreeNode p , TreeNode q){
        if( p == null || q == null) return p == q;

        boolean left = isIdentical(p.left , q.left);
        boolean right = isIdentical(p.right , q.right);

        if( !left || !right ) return false;

        return p.val == q.val;
    }
}
