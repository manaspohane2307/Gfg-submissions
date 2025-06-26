class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        // Step 1: Build adjacency list from edge list
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjlist.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjlist.get(u).add(v);
            adjlist.get(v).add(u); // undirected graph
        }
        
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                if(checkCycle(adjlist, i, visited, -1)){
                    return true;
                }
            }
        }
       return false; 
    }
    
    static boolean checkCycle(ArrayList<ArrayList<Integer>> adjlist, int sr, boolean[] visited, int parent){
        visited[sr] = true;
        //go to all adjacent nodes
        for(int adjnode : adjlist.get(sr)){
            if(visited[adjnode]==false){
                if(checkCycle(adjlist, adjnode, visited, sr)==true){
                    return true;
                }
            }
            else if(adjnode != parent){
                return true;
            }
        }
        return false;
    }
}
