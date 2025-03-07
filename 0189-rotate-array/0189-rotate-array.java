class Solution {
    public void reverse(int l,int r,int arr[]){
        while(l<r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(0,nums.length-1,nums);
        reverse(0,k-1,nums);
        reverse(k,nums.length-1,nums);
    }
}