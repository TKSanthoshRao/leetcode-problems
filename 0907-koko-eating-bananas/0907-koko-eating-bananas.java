class Solution {
    public int cal(int num,int piles[]){
        int sol = 0;
        for(int i : piles){
            sol+=Math.ceil((double)i/num);
        }
        return sol;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i : piles){
            max = Math.max(max,i);
        }
          int ans = max;
        int l = 1,r = max;
        while(l<=r){
            int mid = (l+r)/2;
            if(cal(mid,piles)<=h){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}