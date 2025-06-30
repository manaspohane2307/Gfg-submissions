// User function Template for Java
class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        //adjList
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        for(int i=0;i<E;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        int[] vis = new int[V];
        //step1 - perform topo sort using dfs and store result in stack
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                topoSort(i, adj, vis, st);
            }
        }
        //step2 - pop nodes from stack and relax edges
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = (int)(1e9);
        }
        dist[0] = 0;//src node
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            for(int i=0;i<adj.get(node).size();i++){
                int v = adj.get(node).get(i).first;//adj node
                int wt = adj.get(node).get(i).second;
                if(dist[node]+wt < dist[v]){
                    dist[v] = dist[node] + wt;//relax node
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dist[i]==1e9){
                dist[i] = -1;
            }
        }
       return dist; 
    }
    
    static void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st){
        vis[node] = 1;
        for(int i=0;i<adj.get(node).size();i++){
            int v = adj.get(node).get(i).first;
            if(vis[v]==0){
                topoSort(v,adj,vis,st);
            }
        }
        st.add(node);//add node into stack after completion of dfs call
    }
}

class Pair{
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}