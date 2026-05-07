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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList();

        List<List<Integer>> ans = new ArrayList<>();


        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while( !queue.isEmpty() ){

            List<Integer> curr = new ArrayList<>();
            int n = queue.size();

            while(n > 0){
                TreeNode node = queue.poll();
                curr.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                n--;                
            }

            ans.add(curr);
        }

        return ans;
    }
}
