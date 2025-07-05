class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int max = Integer.MIN_VALUE;
        for(int i : hm.keySet())
        {
        if(hm.get(i) == i)
        max = Math.max(i,max);
        }
        if(max == Integer.MIN_VALUE) return -1;
        return max;
    }
}