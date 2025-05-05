class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums)
        pq.offer(i);
        int kth = -1;
        while(k>0){
            kth = pq.poll();
            k--;
        }
        return kth;

    }
}