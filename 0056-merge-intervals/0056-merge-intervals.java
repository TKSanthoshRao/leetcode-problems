import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    
    /**
     * Brute-force approach to merge intervals.
     * This method iterates through the intervals and merges overlapping ones.
     */
    public int[][] bruteForce(int[][] intervals) {
        ArrayList<ArrayList<Integer>> mergedIntervals = new ArrayList<>();

        // Iterate through each interval
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];  // Extract the start time
            int end = intervals[i][1];    // Extract the end time

            // If the current interval is already merged, skip it
            if (!mergedIntervals.isEmpty()) {
                int lastEnd = mergedIntervals.get(mergedIntervals.size() - 1).get(1);
                if (end <= lastEnd) {
                    continue;
                }
            }

            // Check for overlapping intervals and merge them
            for (int j = i + 1; j < intervals.length; j++) {
                int nextStart = intervals[j][0];
                int nextEnd = intervals[j][1];

                if (nextStart <= end) { // Overlapping interval
                    end = Math.max(end, nextEnd);  // Extend the merged interval's end time
                } else {
                    break; // Stop merging since intervals are sorted
                }
            }

            // Add the merged interval to the list
            mergedIntervals.add(new ArrayList<>(Arrays.asList(start, end)));
        }

        // Convert ArrayList to a 2D integer array and return
        return convertListToArray(mergedIntervals);
    }

    /**
     * Optimized approach to merge intervals.
     * This method efficiently merges overlapping intervals in a single pass.
     */
    public int[][] optimal(int[][] intervals) {
        ArrayList<ArrayList<Integer>> mergedIntervals = new ArrayList<>();

        // Iterate through each interval
        for (int i = 0; i < intervals.length; i++) {
            int currentStart = intervals[i][0];  // Extract start time
            int currentEnd = intervals[i][1];    // Extract end time

            // If the list is empty, add the first interval directly
            if (mergedIntervals.isEmpty()) {
                mergedIntervals.add(new ArrayList<>(Arrays.asList(currentStart, currentEnd)));
                continue;
            }

            // Get the last merged interval's end time
            int lastEnd = mergedIntervals.get(mergedIntervals.size() - 1).get(1);

            // If the current interval overlaps with the last merged one, extend it
            if (currentStart <= lastEnd) {
                int newEnd = Math.max(currentEnd, lastEnd);
                mergedIntervals.get(mergedIntervals.size() - 1).set(1, newEnd);
            } else {
                // No overlap, add the current interval as a new entry
                mergedIntervals.add(new ArrayList<>(Arrays.asList(currentStart, currentEnd)));
            }
        }

        // Convert ArrayList to a 2D integer array and return
        return convertListToArray(mergedIntervals);
    }

    /**
     * Main function to sort and call the merging method.
     */
    public int[][] merge(int[][] intervals) {
        // Sort intervals based on start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Use the optimal merging method (bruteForce can be used instead)
        return optimal(intervals);
    }

    /**
     * Utility method to convert an ArrayList of ArrayLists to a 2D array.
     */
    private int[][] convertListToArray(ArrayList<ArrayList<Integer>> list) {
        int rows = list.size();
        int cols = list.get(0).size();
        int[][] array = new int[rows][cols];

        // Copy elements from list to 2D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = list.get(i).get(j);
            }
        }
        
        return array;
    }
}
