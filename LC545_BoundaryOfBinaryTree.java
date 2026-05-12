/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> boundaryTraversal(Node root) {
        
        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(root.data);
        
        if(root.left == null && root.right == null){
            return ans;
        }
        
        LeftView(root.left , ans);
        LeafView(root , ans);
        RightView( root.right , ans);
        
        return ans;
    }
    
    
    public void LeftView(Node root , List<Integer> ls){
        if(root == null) return;
        if( root.left == null && root.right == null ) return;
        
        ls.add(root.data);
        
        if( root.left != null){
            LeftView(root.left , ls);
        }else{
            LeftView(root.right , ls);
        }
        
    }
    
    public void RightView(Node root , List<Integer> ls){
        if( root == null) return;
        if( root.left == null && root.right == null ) return;
        
            
        if( root.right != null){
            RightView(root.right , ls);
        }else{
            RightView(root.left , ls);
        }
        
        ls.add(root.data); //backtrack
        
    }
    
    public void LeafView(Node root , List<Integer> ls){
        if( root == null) return;
            
        
        if( root.left == null && root.right == null ) ls.add(root.data);
        
        
        LeafView(root.left , ls);
        LeafView(root.right , ls);
        
    }
    

}
