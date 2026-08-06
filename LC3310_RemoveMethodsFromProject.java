class Graph{
    int V;
    List<List<Integer>> adj;

    public Graph(int V){
        this.V = V;
        adj = new ArrayList<>();

        for( int i=0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
    }

    public void createEdge(int u , int v){
        adj.get(u).add(v);
    }
}

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invo) {
        int edge_size = invo.length;
        
        Graph graph = new Graph(n);

        // create graph
        for( int i=0 ; i < edge_size ; i++){
            graph.createEdge(invo[i][0] , invo[i][1]);
        }

        // find susp group
        boolean[] visited = new boolean[n];
        int[] inDegree = new int[n];

        List<List<Integer>> adj = graph.adj;

        // count indegree for each
        for( List<Integer> ls : adj){
            for( int v : ls){
                inDegree[v]++;
            }
        }

        bfs(k , visited , inDegree , adj);

        boolean canRemoved = true;

        for( int i=0 ; i < n ; i++){
            // System.out.println(i+" "+inDegree[i]+" "+visited[i]);
            if( visited[i] && inDegree[i] != 0){
                canRemoved = false;
                break;
            }
        }

        List<Integer> res = new ArrayList<>();

        if( canRemoved ){
            for( int i=0 ; i < n ; i++){
                if( !visited[i] ){
                    // remain
                    res.add(i);
                }
            }
        }else{
            for( int i=0 ; i < n ; i++) res.add(i);
        }

        return res;
    }


    public void bfs(int src , boolean[] visited , int[] inDegree , List<List<Integer>> adj){
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(src);
        visited[src] = true;

        while( !q.isEmpty() ){

            int u = q.poll();

            for( int v : adj.get(u)){
                inDegree[v]--;
                
                if( !visited[v] ){
                    q.offer(v);
                    visited[v] = true;
                }
            }
        }
        


    }

}
