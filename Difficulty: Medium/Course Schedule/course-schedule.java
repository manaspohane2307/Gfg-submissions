class Solution {
    public static ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        //construct adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);//edge v to u for pair (u,v)
        }
        
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        //put elements into queue with indegree 0
        for(int i=0;i<n;i++){
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
        return ans;
    }
}