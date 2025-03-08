class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <=1) return nums.length;
        HashSet<Integer> hs  = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        int maxCnt = 1;
         //Iterator<Integer> it = set.iterator();
        for(int i : hs){
            if(!hs.contains(i-1)){
                int cnt = 0;
                while(true){
                    if(hs.contains(i)){
                        cnt++;
                        i++;
                    }else{
                        break;
                    }
                }
                maxCnt = Math.max(cnt,maxCnt);
            }
        }
        return maxCnt;
    }
}