class Solution {
    public boolean[] sieve(int n){
        boolean arr[] = new boolean[n+1];
        Arrays.fill(arr,true);
        arr[0] = false;
        arr[1] = false;

        for(int i = 2;i*i<=n;i++){
            if(arr[i]){
                for(int j = i*i;j<=n;j+=i){
                    arr[j] = false;
                }
            }
        }
        return arr;
    }
    public int[] closestPrimes(int left, int right) {
        int res[] = new int[2];
        Arrays.fill(res,-1);
        int min = Integer.MAX_VALUE;
        boolean primes[] = sieve(right);
        for(int i = left;i<=right;i++){
           for(int j = left+1;j<=right;j++){
                if(j>i && primes[i] && primes[j]){
                    if((j-i)<min){
                        min = j-i;
                        res[0] = i;
                        res[1] = j;
                    }
                    if(min <=2) return res;
                }
           }
        }

    //   if(res[0] == -1 || res[1] == -1){
    //     res[0] = -1;
    //     res[1] = -1;
    //   }
        return res;
    }
}