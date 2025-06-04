// User function Template for Java

class Solution {
    static void dfs(ArrayList<ArrayList<Integer>> adjlist, int[] vis, int node){
        vis[node] = 1;
        //get neighbors
        for(int it : adjlist.get(node)){
            if(vis[it]==0){
                dfs(adjlist,vis,it);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
       ;//no of nodes=V
        for(int i=0;i<V;i++){
            adjlist.add(new ArrayList<Integer>());
        }
        //change adjmatrix to list
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j) == 1 && i != j){
                    adjlist.get(i).add(j);
                    adjlist.get(j).add(i);
                }
            }
        }
        int[] vis = new int[V];
        int count=0;
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                count++;
                dfs(adjlist,vis,i);
            }
        }
        return count;
    }
};