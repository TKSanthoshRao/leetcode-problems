class Solution {
    public int helper(int i,int[] coins , int tar,int[][] dp){
        if(i == 0){
            if(tar%coins[i] == 0){
                return 1;
            }
            return 0;
        }
        if(dp[i][tar]!=-1)return dp[i][tar];
        int take = 0;
        if(tar>=coins[i])
         take = helper(i,coins,tar-coins[i],dp);
        int ntake = helper(i-1,coins,tar,dp);
        return dp[i][tar] = take+ntake;

    }
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for(int i[] : dp) Arrays.fill(i,-1);
        return helper(coins.length-1,coins,amount,dp);
    }
}