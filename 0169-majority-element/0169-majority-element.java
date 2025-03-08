class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 0) return -1;
        int ele = nums[0];
        int cnt = 0;
      for(int i = 0;i<nums.length;i++){
        if(cnt == 0) ele = nums[i];
        if(nums[i] == ele) cnt++;
        else cnt--;
      }
      cnt = 0;
      for(int i = 0;i<nums.length;i++){
        if(nums[i] == ele) cnt++;
      }
      if(cnt>nums.length/2) return ele;
      return -1;
    }
}