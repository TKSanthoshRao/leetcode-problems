class Solution {

    // Brute force function: Checks every possible bloom day from 'min' to 'max'
    public int bruteforce(int[] bloomDay, int m, int k, int min, int max) {
        int ans = -1;
        for (int i = min; i <= max; i++) {
            if (solve(bloomDay, i, k) >= m) {
                return i;
            }
        }
        return ans;
    }

    // Placeholder for the optimal method (No binary search inside)
    public int optimal(int[] bloomDay, int m, int k, int min, int max) {
        int l = min,r = max,ans = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(solve(bloomDay,mid,k)>=m){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }

    // Function to count how many bouquets can be made for a given bloom day 'num'
    public int solve(int[] arr, int num, int k) {
        int cnt = 0, ans = 0;
        for (int i : arr) {
            if (i <= num) {
                cnt++;
            } else {
                ans += (cnt / k);
                cnt = 0;
            }
        }
        ans += (cnt / k);
        return ans;
    }

    // Main function to find the minimum bloom day
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length, ans = -1;
        if (n < m * k) return ans;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : bloomDay) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        // Calls the optimal function (Right now, it just calls brute force)
        return optimal(bloomDay, m, k, min, max);
    }
}
