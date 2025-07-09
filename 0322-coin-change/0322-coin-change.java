class Solution {
    int helper(int i, int tar, int[] coins, int[][] dp) {
        if (i == 0) {
            if (tar % coins[0] == 0) {
                return tar / coins[i];
            }
            return (int) 1e9;
        }
        if (dp[i][tar] != -1)
            return dp[i][tar];

        int take = Integer.MAX_VALUE;
        if (coins[i] <= tar) {
            take = 1 + helper(i, tar - coins[i], coins, dp);
        }

        int notake = helper(i - 1, tar, coins, dp);
        return dp[i][tar] = Math.min(take, notake);
    }

    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        int sol = helper(coins.length - 1, amount, coins, dp);
        if (sol >= (int) 1e9)
            return -1;
        return sol;
    }
}