class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        //convert edgelist to adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){//size of edge list = no of edges
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }
        
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfsCheck(i,adj,vis,st);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
    
    static void dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[]vis, Stack<Integer> st){
        vis[node] = 1;
        //visit neighbors
        for(int it : adj.get(node)){
            if(vis[it]==0){
                dfsCheck(it,adj,vis,st);
            }
        }
        st.add(node);//during backtrack
    }
}