class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = prices[n-1];
        int profit = 0;
        for(int i = n-2;i>=0;i--){
            profit = Math.max(max-prices[i],profit);
            max = Math.max(prices[i],max);
        }
        return profit;
    }
}