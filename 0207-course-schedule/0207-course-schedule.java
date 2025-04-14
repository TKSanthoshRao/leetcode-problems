class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();
        int inDegree[] = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i = 0;i<prerequisites.length;i++){
            inDegree[prerequisites[i][1]]++;
        }
        int cnt = 0;
        for(int i = 0;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                q.offer(i);
                cnt++;
            }
        }
        while(!q.isEmpty()){
           for(int i : adj.get(q.poll())){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    q.offer(i);
                    cnt++;
                }
            }
        }
        return cnt == numCourses;
    }
}