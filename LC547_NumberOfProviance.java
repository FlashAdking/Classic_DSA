class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int iter = 0;
        
        boolean[] visited = new boolean[n];


        for( int i=0 ; i < n ; i++){
            if( !visited[i] ){
                BFS(i , visited , isConnected);
                iter++;
            }
        }

        return iter;
    }
    
    public void BFS(int start ,boolean[] visited , int[][] matrix){

        Queue<Integer> q = new ArrayDeque<>();

        visited[start] = true;
        q.offer(start);

        while( !q.isEmpty() ){
            int u = q.poll();

            for( int v=0 ; v < visited.length ; v++){
                if( !visited[v] && matrix[u][v] == 1){
                    q.offer(v);
                    visited[v] = true;
                }
            }

        }

    }

}
