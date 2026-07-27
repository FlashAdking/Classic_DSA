class Solution {
    public boolean canReach(int[] start, int[] target) {
        if( start[0] == target[0] && start[1] == target[1]) return true;

        int[] ans = new int[1];

        ans[0] = -1;

        boolean visited[][] = new boolean[8][8];
        
        DFS(start[0] , start[1] , target , visited , ans , 0);

        return ans[0] % 2 == 0;
    }

    public void DFS( int i , int j , int[] target , boolean[][] visited , int[] res , int count){
        if( i < 0 || j < 0 || i >= 8 || j >= 8 || visited[i][j] ) return;

        visited[i][j] = true;

        if( i == target[0] && j == target[1]){
            res[0] = count;
            return;
        }

        
        // right
        DFS( i-1 ,  j+2 , target , visited , res , count+1);
        DFS( i+1 ,  j+2 , target , visited , res , count+1);

        // left
        DFS( i-1 ,  j-2 , target , visited , res , count+1);
        DFS( i+1 ,  j-2 , target , visited , res , count+1);

        // top
        DFS( i+2 ,  j-1 , target , visited , res , count+1);
        DFS( i+2 ,  j+1 , target , visited , res , count+1);

        // down
        DFS( i-2 ,  j-1 , target , visited , res , count+1);
        DFS( i-2 ,  j+1 , target , visited , res , count+1);
        
    }
}
