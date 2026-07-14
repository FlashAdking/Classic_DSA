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
class Tuple{
    int level;
    int value;

    public Tuple(){}

    public Tuple(int vertical , int level , int value){
        this.level = level;
        this.value = value;
    }
}

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Tuple tuple = new Tuple();
        tuple.value = root.val;
        tuple.level = 0;

        TraverseTree(root , 0, tuple);

        return tuple.value;
    }

    public void TraverseTree(TreeNode root, int level , Tuple tuple){
        if( root == null ) return;

        if( tuple.level <= level ){
            tuple.value = root.val;
            tuple.level = level;
        }


        TraverseTree(root.right , level+1 , tuple);
        TraverseTree(root.left , level+1 , tuple);
    }
}
