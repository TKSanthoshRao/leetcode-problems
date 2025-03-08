class Solution {
    public int[] rearrangeArray(int[] nums) {
        int arr[] = new int[nums.length];
        if(nums.length<2) return nums;
        int pos = 0,neg = pos+1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>0){
                arr[pos] = nums[i];
                pos+=2;
            }else{
                arr[neg] = nums[i];
                neg+=2;
            }
        }
        return arr;
    }
}