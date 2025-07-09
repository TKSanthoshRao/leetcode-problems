class Solution {
    public int helper(int i,String s,int[] dp){
        if(i >= s.length()) return 1;
        if(dp[i]!=-1) return dp[i];
        if(s.charAt(i) == '0') return 0;
        int cnt = helper(i+1,s,dp);
        int cnt2 = 0;
    if (i + 1 < s.length()) {
        String sub = s.substring(i,i+2);
        if(Integer.parseInt(sub)<=26)
        cnt2 = helper(i+2,s,dp);
    }
        return dp[i] = cnt+cnt2;
    }
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(0 ,s,dp);
    }
}