/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Tuple{
    int level;
    int value;
    
    Tuple(){}
    
    Tuple(int level , int value){
        this.level = level;
        this.value = value;
    }
}

class Solution {
    public ArrayList<Integer> topView(Node root) {
        if( root == null ) return new ArrayList<>();
        
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer , Tuple> tree = new TreeMap<>();

        traverse(root , 0 , 0, tree);
        

        tree.forEach( (k , v) -> result.add( v.value ));

        return result;
        
    }
    
    public void traverse(Node root , int vertical , int level , Map<Integer,Tuple> map){
        if( root == null ) return;
        
        map.computeIfAbsent(vertical , k -> new Tuple(level , root.data));
        
        
        
        map.computeIfPresent( vertical , (k , v) -> {
            if( v.level > level ){
                v.level = level;
                v.value = root.data;
            }
            
            return v;
        });
        
        traverse(root.left , vertical-1  , level+1, map);
        traverse(root.right , vertical+1 , level+1, map);
    }
    
    
}




