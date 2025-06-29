// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        // Your code here
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfsCheck(i, adj, vis, pathVis, check);
            }
        }
        List<Integer> safenodes = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i]==1){
                safenodes.add(i);
            }
        }
        return safenodes;
    }
    
    boolean dfsCheck(int node, List<List<Integer>> adj, int[] vis, int[] pathVis, int[] check){
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        //traverse adjacent nodes
        for(int it : adj.get(node)){
            if(vis[it]==0){
                if(dfsCheck(it, adj, vis, pathVis, check)==true){
                    return true;
                }
            }
            else if(pathVis[it]==1){
                return true;//cycle detected
            }
        }
        check[node] = 1;//during backtracking
        pathVis[node] = 0;
        return false;
    }
}
