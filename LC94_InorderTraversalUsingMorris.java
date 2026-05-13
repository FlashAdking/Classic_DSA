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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList();

        TreeNode curr = root;
        List<Integer> ans = new ArrayList<>();

        while( curr != null){

            if( curr.left != null){

                TreeNode leftNode = curr.left;

                while( leftNode.right != null && leftNode.right != curr){
                    leftNode = leftNode.right;
                }

                if( leftNode.right == null){
                    leftNode.right = curr;

                    curr = curr.left;
                }else{

                    // leftsubtree traversed
                    leftNode.right = null;
                    ans.add(curr.val);
                    curr = curr.right;

                }

            }else{
                
                ans.add(curr.val);

                curr = curr.right;

            }
        }


        return ans;

    }
}
