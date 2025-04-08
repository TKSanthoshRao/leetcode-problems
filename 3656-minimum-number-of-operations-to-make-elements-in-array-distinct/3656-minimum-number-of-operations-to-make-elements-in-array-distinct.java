class Solution {
    public int minimumOperations(int[] nums) {
        boolean arr[] = new boolean[nums.length];
        HashSet<Integer> hs = new HashSet<>();
        for(int i = nums.length-1;i>=0;i--){
            if(hs.isEmpty() || !hs.contains(nums[i])){
                hs.add(nums[i]);
                arr[i] = true;
            }else{
                break;
            }
        }
        int cnt = 0;
    for(int i = 0;i<arr.length;i+=3){
        if(arr[i]) return cnt;
        else
        cnt++;
    }
    return cnt;
    }
}