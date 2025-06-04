class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    static void bfs(char[][] grid, int[][] vis, int row, int col) {
        Queue<Pair> q = new LinkedList<>();
        vis[row][col] = 1;
        q.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int qrow = q.peek().first;
            int qcol = q.peek().second;
            q.remove();
            // traverse in 8 directions - neighbours
            for (int drow = -1; drow <= 1; drow++) {
                for (int dcol = -1; dcol <= 1; dcol++) {
                    int neighrow = qrow + drow;
                    int neighcol = qcol + dcol;
                    if (neighrow >= 0 && neighrow < n && neighcol >= 0 && neighcol < m
                            && vis[neighrow][neighcol] == 0 && grid[neighrow][neighcol] == 'L') {
                        vis[neighrow][neighcol] = 1;
                        q.add(new Pair(neighrow, neighcol));
                    }
                }
            }
        }
    }
    public int countIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 'L') {
                    count++;
                    bfs(grid, vis, i, j);
                }
            }
        }
        return count;
    }
}
