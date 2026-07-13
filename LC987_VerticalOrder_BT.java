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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        Map<Integer, Map<Integer ,Queue<Integer> >> map = new TreeMap<>();

        VerticalTraverse( root , 0 , 0 , map);

        List<List<Integer>> result = new ArrayList<>();

        System.out.println(map);

        for( Map<Integer , Queue<Integer>> levels : map.values()){
            List<Integer> column = new ArrayList<>();
            for( Queue<Integer> pq : levels.values()){
                while( !pq.isEmpty() ) column.add(pq.poll());
            }

            result.add(column);
        }


        return result;
    }

    public void VerticalTraverse( TreeNode root , int vertical , int level , Map<Integer, Map<Integer ,Queue<Integer> >> map){
        if(root == null) return;

        map.computeIfAbsent( vertical , v -> new TreeMap<>())
                            .computeIfAbsent( level , l -> new PriorityQueue<>())
                            .offer( root.val );


        VerticalTraverse( root.left , vertical-1 , level+1 , map);
        VerticalTraverse( root.right , vertical+1 , level+1 , map);
    }
}
