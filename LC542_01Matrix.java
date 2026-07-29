class Tuple{
    int i , j , dist;

    public Tuple(int i, int j , int dist){
        this.i = i;
        this.j = j;
        this.dist = dist;
    }

}


class Solution {
    public int[][] updateMatrix(int[][] mat) {

        Queue<Tuple> queue = new ArrayDeque<>();

        boolean[][] visited = new boolean[mat.length][mat[0].length];

        for( int i=0 ; i < mat.length ; i++){
            for(int j=0 ; j < mat[0].length ; j++){
                if( mat[i][j] == 0){
                    visited[i][j] = true;
                    queue.offer( new Tuple(i , j , 0));
                }
            }
        }

        bfs(queue ,visited, mat);

        return mat;
    }

    public void bfs( Queue<Tuple> queue ,boolean[][] visited , int[][] mat){
        while( !queue.isEmpty() ){
            Tuple tuple = queue.poll();

            int i=tuple.i , j=tuple.j;
            mat[i][j] = tuple.dist;

            // down
            if( i+1 < visited.length && !visited[i+1][j]){
                visited[i+1][j] = true;
                queue.offer( new Tuple( i+1 , j , tuple.dist+1));
            }

            // up
            if( i-1 >= 0 && !visited[i-1][j]){
                visited[i-1][j] = true;
                queue.offer( new Tuple( i-1, j, tuple.dist+1));
            }

            // left
            if( j-1 >= 0 && !visited[i][j-1]){
                visited[i][j-1] = true;
                queue.offer( new Tuple( i , j-1 , tuple.dist+1));
            }

            // right
            if( j+1 < visited[0].length && !visited[i][j+1]){
                visited[i][j+1] = true;
                queue.offer( new Tuple( i , j+1 , tuple.dist+1));
            }

        }
    }
}
