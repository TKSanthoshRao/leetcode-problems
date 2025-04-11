class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt =  0;
        for(int i = low;i<=high;i++){
            String str = String.valueOf(i);
            if(str.length()%2 == 0){
                char arr[] = str.toCharArray();
                int n = str.length();
                int sum1 = 0,sum2 = 0;
                for(int j = 0;j<n/2;j++){
                    sum1+=Integer.parseInt(String.valueOf(arr[j]));
                }
                 for(int j = n/2;j<n;j++){
                    sum2+=Integer.parseInt(String.valueOf(arr[j]));
                }
                if(sum1==sum2) cnt++;

            }
        }
        return cnt;
    }
}