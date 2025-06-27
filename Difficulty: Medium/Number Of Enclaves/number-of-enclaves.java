// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        //traverse matrix and put boundary elements into queue and mark them visited
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if(i==0 || i==n-1 || j==0 || j==m-1){
                        q.add(new Pair(i,j));
                        visited[i][j]=1;
                    }
                }
            }
        }
        //traverse in 4 directions using bfs
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            visited[row][col] = 1;
            q.poll();
            //traverse in 4 directions
            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1
                && visited[nrow][ncol]==0){
                    q.add(new Pair(nrow,ncol));
                    visited[nrow][ncol] = 1;
                }
            }
        }
        //count unvisited 1's
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}

class Pair{
    int first,second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}