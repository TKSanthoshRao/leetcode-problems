class Solution {
    public int helper(int i,int j,int[] nums1,int[] nums2,int dp[][]){
        if(i>=nums1.length || j>=nums2.length) return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(nums1[i] == nums2[j]) return 1 + helper(i + 1, j + 1, nums1, nums2,dp);
         int way1  =  helper(i+1,j,nums1,nums2,dp);
        int way2 = helper(i,j+1,nums1,nums2,dp);
        return dp[i][j] = Math.max(way1,way2);

    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
     int n1 = nums1.length;
     int n2 = nums2.length;
     int dp[][] = new int[nums1.length][nums2.length];
     for(int i[] : dp)Arrays.fill(i,-1);
        return helper(0,0,nums1,nums2,dp);
    }
}