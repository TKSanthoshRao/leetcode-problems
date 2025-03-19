class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0,r = arr.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if((arr[mid]-(mid+1))<k){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l+k;

    }
}