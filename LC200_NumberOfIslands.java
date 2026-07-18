class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];

        int ans = 0;
        
        for( int i=0 ; i < m ; i++){
            for( int j=0 ; j < n ; j++){
                if( !visited[i][j] && grid[i][j] == '1'){
                    DFS( i ,j , visited , grid);
                    ans++;
                }
            }
        }

        return ans;
    }

    public void DFS(int i , int j ,boolean[][] visited , char[][] matrix){
        if( i < 0 || j < 0
            || i >= matrix.length
            || j >= matrix[0].length
            || visited[i][j]
            || matrix[i][j] == '0' ) return;

            visited[i][j] = true;

            DFS( i-1 , j , visited , matrix); // top
            DFS( i+1 , j , visited , matrix); // down
            DFS( i , j-1 , visited , matrix); // left
            DFS( i , j+1 , visited , matrix); // right

    }
}
