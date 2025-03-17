class Solution {
    public int sum(int[] nums,int mid){
        int sum = 0;
        for(int i : nums){
            sum+=Math.ceil((double)i/mid);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            max = Math.max(i,max);
        }
        int l = 1,r = max,ans = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(sum(nums,mid)<=threshold){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}