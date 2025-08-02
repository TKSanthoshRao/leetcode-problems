class Solution {
    public int helper(int i,int j,int prevcol,int[][] grid,int m,int n,int dp[][]){
        if(i == m-1) return grid[i][j];
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = 0;k<m;k++){
            if(k!=prevcol){
                min = Math.min(min,grid[i][j]+helper(i+1,k,k,grid,m,n,dp));
            }
        }
        return dp[i][j] = min;

    }
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[n][n];
        for(int i[] : dp) Arrays.fill(i,Integer.MAX_VALUE);
        for(int j = 0;j<n;j++) dp[0][j] = grid[0][j];
        for(int i = 1;i<n;i++){
            for(int j = 0;j<m;j++){
                for(int k = 0;k<n;k++){
                    if(k!=j)
                    dp[i][j] = Math.min(dp[i][j],grid[i][j]+dp[i-1][k]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
            for(int i = 0;i<n;i++){
                ans = Math.min(dp[m-1][i],ans);
            }
            return ans;
    }
}