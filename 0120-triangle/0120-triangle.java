class Solution {
    public int helper(int i,int j,int m,List<List<Integer>> tri,int[][] dp){
        if(i == m-1) return tri.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        int down = helper(i+1,j,m,tri,dp);
        int down1 = helper(i+1,j+1,m,tri,dp);
        return dp[i][j] = Math.min(down,down1)+tri.get(i).get(j);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<m;j++){
                dp[i][j] = -1;
            }
        }
        return helper(0,0,m,triangle,dp);
    }
}