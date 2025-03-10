class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int  n = nums.length;
        for(int i = 0;i<nums.length;i++){
                if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1;j<nums.length;j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1, l = n-1;
                while(k<l){
                long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if(sum>target){
                        l--;
                    }else if(sum<target){
                        k++;
                    }else{
                       ArrayList<Integer> arr = new ArrayList<>() ;
                       arr.addAll(List.of(nums[i],nums[j],nums[k],nums[l]));
                       result.add(arr);
                       k++;
                       l--;
                       while(k<l && nums[k]==nums[k-1])k++;
                       while(k<l && nums[l] == nums[l+1])l--;
                    }
                }
            }
        }
        return result;
    }
}