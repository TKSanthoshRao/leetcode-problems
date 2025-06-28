public class Pair{
    int x,y,effort;
    public Pair(int x,int y,int dis){
        this.x = x;
        this.y = y;
        this.effort = dis;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length,n = heights[0].length;
        int e[][] = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                e[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> a.effort-b.effort);
        pq.offer(new Pair(0,0,0));
        int row[] = {0,0,-1,+1};
        int col[] = {-1,+1,0,0};
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if (curr.x == m - 1 && curr.y == n - 1) return curr.effort;
            for(int i = 0;i<4;i++){
                int nr = row[i]+curr.x;
                int nc = col[i]+curr.y;
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int newEffort = Math.max(curr.effort, Math. abs(heights[curr.x] [curr.y] - heights[nr][nc]));
                    if (newEffort < e[nr][nc]) {
                        e[nr][nc] = newEffort;
                        pq.offer(new Pair(nr, nc, newEffort));
                    }

                }
            }
        }
        return 0;
    }
}