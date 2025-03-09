class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int n = nums.length;
        for(int i: nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i : hm.keySet()){
            if(hm.get(i)>n/3){
                arr.add(i);
            }
        }
        return arr;
    }
}