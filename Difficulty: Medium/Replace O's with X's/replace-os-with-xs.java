// User function Template for Java

class Solution {
    static void dfs(int row, int col, char[][] mat, int[][] visited, int[] delrow, int[] delcol){
        visited[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        //traverse boundaries
        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 
            && mat[nrow][ncol]=='O'){
                dfs(nrow, ncol, mat, visited, delrow, delcol);
            }
        }
    }
    
    static char[][] fill(char mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int[][] visited = new int[n][m];
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        //traverse first row and last row
        for(int j=0;j<m;j++){
            //first row
            if(mat[0][j]=='O'){
                dfs(0, j, mat, visited, delrow, delcol);
            }
            //last row
            if(mat[n-1][j]=='O'){
                dfs(n-1, j, mat, visited, delrow, delcol);
            }
        }
        //traverse first col and last col
        for(int i=0;i<n;i++){
            //first col
            if(mat[i][0]=='O'){
                dfs(i, 0, mat, visited, delrow, delcol);
            }
            //last col
            if(mat[i][m-1] == 'O'){
                dfs(i, m-1, mat, visited, delrow, delcol);
            }
        }
        //final part - convert unvisited Os to X
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]=='O' && visited[i][j]==0){
                    mat[i][j] = 'X';
                }
            }
        }
        return mat;
    }
}