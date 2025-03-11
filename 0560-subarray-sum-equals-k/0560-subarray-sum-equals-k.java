class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums.length<0) return 0;
        int cnt = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int prefixsum = 0;
       for(int i = 0;i<nums.length;i++){
        prefixsum+=nums[i];
        int val = prefixsum-k;
        if(hm.containsKey(val)){
            cnt+=hm.get(val);
        }
        hm.put(prefixsum,hm.getOrDefault(prefixsum,0)+1);
       }
       return cnt;
    }
}