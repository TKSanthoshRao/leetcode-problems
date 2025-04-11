class Pair{
    int x,y,time;
    public Pair(int x,int y,int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
class Solution {
    public int bfs(Pair node,int grid[][],boolean visited[][]){
        int m = grid.length,n = grid[0].length;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(node);
        visited[node.x][node.y] = true;
        int row[] = {-1, -1, -1, 0, 1, 1, 1, 0};
        int col[] = {-1, 0, 1, 1, 1, 0, -1, -1};
        while(!q.isEmpty()){
            Pair cell = q.poll();
            int  x = cell.x;
             int y = cell.y;
            int t = cell.time;
             if (x == m - 1 && y == n - 1)
                return t;
            for(int i = 0;i<8;i++){
                int newRow = x+row[i];
                int newCol = y+col[i];
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol] == 0 && !visited[newRow][newCol]){
                        visited[newRow][newCol] = true;
                        q.offer(new Pair(newRow,newCol,t+1));
                }
            }
        }
     return -1;

    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int m = grid.length,n = grid[0].length;
        if((grid[0][0] == 1) || (grid[m-1][n-1] == 1)) return -1;
        return bfs(new Pair(0,0,1),grid,visited);

    }
}