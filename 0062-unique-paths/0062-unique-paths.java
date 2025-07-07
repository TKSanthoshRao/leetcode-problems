class Solution {
    public static int helper(int i,int j,int m,int n,int dp[][]){
        if(i == m-1 && j == n-1){
            return 1; 
        }
        if(i>=m || j>=n) return 0;
        if(dp[i][j]!=Integer.MIN_VALUE)return dp[i][j];
        return dp[i][j] =  helper(i+1,j,m,n,dp) + helper(i,j+1,m,n,dp);
    }
    public int uniquePaths(int m, int n) {
        int cnt[] = new int[1];
        int dp[][] = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return helper(0,0,m,n,dp);
    }
}