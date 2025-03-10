class Solution {
    public void moveZeroes(int[] arr) {
        int j = -1;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                j =i;
                break;
            }
        }
        if(j == -1) return;
        for(int i = j+1;i<arr.length;i++){
            if(arr[i]!=0){
                int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    j++;
            }
        }
    }
}