class Solution {
   // ->>>>>>>>> RECURSIVE APPROACH

    // public static int helper(int i,int n,int[] nums){
    //     if(i>n) return 0;
    //     if(i == n) return nums[i];
    //     int take = helper(i+2,n,nums)+nums[i];
    //     int notTake = helper(i+1,n,nums)+0;
    //     return Math.max(take,notTake);
    // }
    public int dypr(int[] nums){
        int n = nums.length;
       int[] dp = new int[n];
        dp[0] = nums[0];
       for(int i = 1;i<n;i++){
        int take = nums[i];
            if(i>1) take+=dp[i-2];
        int notTake = dp[i-1];
       dp[i] = Math.max(take,notTake);
       }
       return dp[n-1];
    }
    public int rob(int[] nums) {
       //return Math.max(helper(0,nums.length-2,nums),helper(1,nums.length-1,nums));
       if(nums.length == 1) return nums[0];
       int temp1[] = new int[nums.length-1];
       int temp2[] = new int[nums.length-1];
       int k1 = 0,k2 = 0;
       for(int i = 0;i<nums.length;i++){
        if(i!=0)temp1[k1++] = nums[i];
        if(i!=nums.length-1)temp2[k2++] = nums[i];
       }
       return Math.max(dypr(temp1),dypr(temp2));
    }
}