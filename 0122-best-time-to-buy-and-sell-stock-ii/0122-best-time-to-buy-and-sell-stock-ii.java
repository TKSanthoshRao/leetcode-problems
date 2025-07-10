class Solution {
    public int helper(int i,int[] prices,boolean buy,int[][] dp){
        if(i>=prices.length) return 0;
        int b = buy ?1:0;
        if(dp[i][b]!=-1) return dp[i][b];
        if(!buy){
            int canBuy = -prices[i] + helper(i+1,prices,true,dp);
            int cannotBuy = helper(i+1,prices,false,dp);
            return dp[i][b] = Math.max(canBuy,cannotBuy);
        }

            int sell = prices[i] +helper(i+1,prices,false,dp);
            int dontSell = helper(i+1,prices,true,dp);
            return dp[i][b] = Math.max(sell,dontSell);
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int i[] : dp) Arrays.fill(i,-1);
        return helper(0,prices,false,dp);
    }
}