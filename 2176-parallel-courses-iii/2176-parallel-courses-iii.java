class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++)
        {
             adj.add(new ArrayList<Integer>());
        }

        int indeg[] = new int[n+1];

        for(int i = 0;i<relations.length;i++){
            adj.get(relations[i][0]).add(relations[i][1]);
            indeg[relations[i][1]]++;
        }
        int arr[] = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1;i<indeg.length;i++){
            if(indeg[i] == 0){
                q.offer(i);
                arr[i] = time[i-1];
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
                for(int i : adj.get(node)){
                    indeg[i]--;
                    if(indeg[i] == 0){
                        q.offer(i);
                    }
                    arr[i] = Math.max(arr[i],(arr[node]+time[i-1]));
                }
        }
        int max = Integer.MIN_VALUE;
        for(int i : arr) max = Math.max(max,i);
        return max;
    }
}