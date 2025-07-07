class Solution {
    // public int sum(int i,int j,int[][] grid,int[][] dp){
    //     if(i == 0 && j == 0) return grid[i][j];
    //     if(i<0 || j<0) return Integer.MAX_VALUE;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int up = sum(i-1,j,grid,dp);
    //     int left = sum(i,j-1,grid,dp);
    //     return dp[i][j] = Math.min(up,left)+grid[i][j];
    // }
    public int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 && j == 0) continue;
                int up = Integer.MAX_VALUE;
                if(i>0)
                 up =   dp[i-1][j];
                 int left = Integer.MAX_VALUE;
                if(j>0)
                 left = dp[i][j-1];
                dp[i][j] = Math.min(up,left)+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}