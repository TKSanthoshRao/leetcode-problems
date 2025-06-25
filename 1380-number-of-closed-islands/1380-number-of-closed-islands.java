class Solution {
    public void dfs(int i, int j, int m, int n, int[][] grid, boolean[][] vis) {
        vis[i][j] = true;
        int row[] = { 0, 0, -1, +1 };
        int col[] = { -1, +1, 0, 0 };
        for (int k = 0; k < 4; k++) {
            int nr = row[k] + i, nc = col[k] + j;
            if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 0 && !vis[nr][nc]) {
                dfs(nr, nc, m, n, grid, vis);
            }
        }
    }

    public int closedIsland(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        for(int i = 0;i<n;i++){
            if(grid[0][i] == 0 && !vis[0][i]){
                dfs(0,i,m,n,grid,vis);
            }
        }
        for(int i = 0;i<m;i++){
            if(grid[i][n-1] == 0 && !vis[i][n-1]){
                dfs(i,n-1,m,n,grid,vis);
            }
        }
        for(int i = n-1;i>=0;i--){
            if(grid[m-1][i] == 0 && !vis[m-1][i]){
                dfs(m-1,i,m,n,grid,vis);
            }
        }
        for(int i = m-1;i>=0;i--){
            if(grid[i][0] == 0 && !vis[i][0]){
                dfs(i,0,m,n,grid,vis);
            }
        }
        int cnt = 0;
            for(int i = 0;i<m;i++){
                for(int j = 0;j<n;j++){
                    if(grid[i][j] == 0 && !vis[i][j]){
                        dfs(i,j,m,n,grid,vis);
                        cnt++;
                    }
                }
            }
            return cnt;
    }
}