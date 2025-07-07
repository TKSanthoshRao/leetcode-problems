class Solution {
    public int helper(int i,int j,int[][] grid,int m,int n,int dp[][]){
        if(i == 0 && j == 0 && grid[i][j]!=1) return 1;
        if(i<0 || j<0||grid[i][j] == 1) return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int down = helper(i-1,j,grid,m,n,dp);
        int right = helper(i,j-1,grid,m,n,dp);
        return dp[i][j] = down+right;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length,n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return helper(m-1,n-1,obstacleGrid,m,n,dp);
    }
}