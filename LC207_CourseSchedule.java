class Graph{
    int V;
    Map<Integer , List<Integer>> adj;


    public Graph(int V){
        this.V = V;
        adj = new HashMap<>();
    }

    public void createEdge(int v , int u){
        adj.putIfAbsent(u , new ArrayList<>());
        adj.get(u).add(v);
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] req) {
        Graph graph = new Graph(numCourses);

        // create edges
        for(int i=0 ; i < req.length ; i++){
            graph.createEdge(req[i][0] , req[i][1]);
        }

        boolean[] path = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        for( int i=0 ; i < numCourses ; i++){
            if( !visited[i] ){
                if( dfsCycle(i , visited , path , graph.adj)) return false;
            }
        }


        return true;
    }

    public boolean dfsCycle(int u , boolean[] visited, boolean[] path, 
                            Map<Integer , List<Integer>> adj){

        visited[u] = true;
        path[u] = true;

        for( int v : adj.getOrDefault(u , Collections.emptyList()) ){
            if( !visited[v]){
                if( dfsCycle(v , visited , path , adj) ) return true;
            }else if( path[v] ){
                return true;
            }
        }

        // backtrack
        path[u] = false;

        return false;
    }
}
