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
        int[] parent = new int[V];
        Arrays.fill(parent,-1);
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                if(checkCycle(adjlist, i, visited, parent)){
                    return true;
                }
            }
        }
       return false; 
    }
    
    static boolean checkCycle(ArrayList<ArrayList<Integer>> adjlist, int sr, boolean[] visited, int[] parent){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sr, -1));//parent of source node is -1
        visited[sr] = true;
        
        while(!q.isEmpty()){
            Node temp = q.poll();
            int nodeval = temp.first;
            int parentval = temp.second;
            //go to all adjacent nodes
            for(Integer it : adjlist.get(nodeval)){
                if(visited[it]==false){
                    q.add(new Node(it,nodeval));
                    visited[it] = true;
                }
                else if(parentval != it){//its visited and its value is unequal to parent
                    return true;//found cycle
                }
            }
        }
        return false;
    }
}

class Node{
    int first;
    int second;
    Node(int first, int second){
        this.first = first;
        this.second = second;
    }
}