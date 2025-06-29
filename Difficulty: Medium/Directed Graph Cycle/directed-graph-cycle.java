class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){//size of edge list = no of edges
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }
        
        //indegree array
        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        //put elements into queue with indegree 0
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        //start bfs
        while(!q.isEmpty()){
            int val = q.poll();
            ans.add(val);
            //reduce indegree of neighbors
            for(int it : adj.get(val)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        //check size of ans with V
        if(ans.size()==V){
            return false;
        }
        return true;
    }
}