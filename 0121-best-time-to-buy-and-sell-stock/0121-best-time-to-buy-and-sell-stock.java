class Solution {
    public int maxProfit(int[] prices) {
         int max = Integer.MIN_VALUE;
        int min = prices[0];
        int cost = 0;
        for(int i = 1;i<prices.length;i++){
            cost = prices[i]-min;
            max = Math.max(cost,max);
            min = Math.min(min,prices[i]);
        }
        return Math.max(max,0);
    }
}