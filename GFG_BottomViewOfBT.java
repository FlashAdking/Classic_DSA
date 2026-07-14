/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/
class Tuple{
    int level;
    int value;
    
    public Tuple(){}
    
    public Tuple(int level , int value){
        this.level = level;
        this.value = value;
    }
}


class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        Map<Integer , Tuple> tree = new TreeMap<>();
        
        TraverseTree(root , 0 , 0 , tree);
        
        ArrayList<Integer> res = new ArrayList<>();
        
        tree.forEach( (k , v)->  res.add( v.value ) );
        
        return res;
    }
    
    public void TraverseTree(Node root , int vertical , int level ,Map<Integer , Tuple> map){
        if( root == null) return;
        
        map.putIfAbsent(vertical , new Tuple());
        
        map.compute( vertical , (k,v) -> {
            if( v.level <= level ){
                v.level = level;
                v.value = root.data;
            }
            
            return v;
        });
        
        
        TraverseTree(root.left , vertical-1 , level+1 , map);
        TraverseTree(root.right , vertical+1 , level+1 , map);
    }
}




