class Solution {
    public void helper(int idx,ArrayList<Integer> arr,List<List<Integer>> sol,int[] can,int tar){
        if(idx == can.length) {
            if(tar == 0)
                sol.add(new ArrayList<>(arr));
            return;
        }
        if(tar<0) return;
        arr.add(can[idx]);
        helper(idx,arr,sol,can,tar-can[idx]);
        arr.remove(arr.size()-1);
        helper(idx+1,arr,sol,can,tar);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        helper(0,arr,sol,candidates,target);
        return sol;
    }
}