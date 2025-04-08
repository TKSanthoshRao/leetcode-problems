import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        for (int ops = 0; ops <= (n + 2) / 3; ops++) {
            int start = Math.min(ops * 3, n); // index to start checking
            HashSet<Integer> seen = new HashSet<>();
            boolean isDistinct = true;

            for (int i = start; i < n; i++) {
                if (seen.contains(nums[i])) {
                    isDistinct = false;
                    break;
                }
                seen.add(nums[i]);
            }

            if (isDistinct) return ops;
        }
        return (n + 2) / 3; // worst case: remove whole array
    }
}
