class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];


        for( int i=0 ; i < m ; i++){
            for( int j=0 ; j < n ; j++){
                if( ( i == 0 || i == m-1 || j == 0 || j == n-1) && !visited[i][j] && grid[i][j] == 1){
                    dfs(i , j , visited , grid);
                }
            }
        }


        return count(visited , grid);
    }

    public int count(boolean[][] visited , int[][] matrix){
        int count = 0;
        for( int i=0 ; i < matrix.length ; i++){
            for( int j=0 ; j < matrix[0].length ; j++){
                if( !visited[i][j] && matrix[i][j] == 1) count++;
            }
        }

        return count;
    }

    public void dfs(int i , int j , boolean[][] visited ,int[][] matrix){
        if( i < 0 || j < 0 || i == matrix.length || 
            j == matrix[0].length || visited[i][j] || matrix[i][j] == 0) return;

            visited[i][j] = true;
            // left
            dfs(i , j-1 , visited , matrix);
            // right
            dfs(i , j+1 , visited , matrix);
            // up
            dfs(i-1 , j , visited , matrix);
            // down
            dfs(i+1 , j , visited , matrix);

    }
}
