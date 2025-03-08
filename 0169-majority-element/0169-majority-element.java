class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 0) return -1;
        int ele = 0;
        int cnt = 0;
      for(int i = 0;i<nums.length;i++){
        if(cnt == 0){ 
            ele = nums[i];
            cnt = 1;
        }
        else if(nums[i] == ele) cnt++;
        else cnt--;
      }
    return ele;

    }
}