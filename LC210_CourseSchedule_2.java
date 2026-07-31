class Graph{
    int V;
    Map<Integer , List<Integer>> adj;

    public Graph(int V){
        this.V = V;
        adj = new HashMap<>();
    }

    public void createEdge(int u , int v){
        adj.putIfAbsent(u , new ArrayList<>());
        adj.get(u).add(v);
    }
}

class Solution {
    public int[] findOrder(int n, int[][] req) {
        Graph graph = new Graph(n);

        Stack<Integer> stack = new Stack<>();

        for( int i=0 ; i < req.length ; i++){
            graph.createEdge(req[i][1] , req[i][0]);
        }

        boolean[] visited = new boolean[n]; 
        boolean[] recPath = new boolean[n];

        for( int i=0 ; i < n ; i++){
            if( !visited[i] ){
                if(dfs(i , visited , recPath , stack , graph.adj)) return new int[]{};
            }
        }

        int[] res = new int[n];
        int iter=0;
        
        while(!stack.isEmpty()){
            res[iter++] = stack.pop();
        }

        return res;
    }

    public boolean dfs(int u , boolean[] visited , boolean[] recPath ,Stack<Integer> stack , Map<Integer,List<Integer>> adj){

        visited[u] = true;
        recPath[u] = true;

        for( int v : adj.getOrDefault(u , Collections.emptyList())){
            if( !visited[v]){
                if( dfs(v , visited , recPath , stack , adj)) return true;
            }else if(recPath[v]){
                return true;
            }
        }


        stack.push(u);
        recPath[u] = false; // backtrack
        return false;
    }
}
