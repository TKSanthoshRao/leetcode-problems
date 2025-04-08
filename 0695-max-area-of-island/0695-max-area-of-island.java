class Pair{
    int x,y;
    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int bfs(Pair cell,int[][] grid){
        int m = grid.length,n = grid[0].length;
        int cnt = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(cell);
        grid[cell.x][cell.y] = 0;
        int row[] = {-1,+1,0,0};
        int col[] = {0,0,-1,+1};
        while(!q.isEmpty()){
            Pair node = q.poll();
            int r = node.x;
            int c = node.y;
            for(int i = 0;i<4;i++){
                int newRow = row[i]+r;
                int newCol = col[i]+c;
                if(newRow<m && newRow>=0 && newCol<n && newCol>=0 && grid[newRow][newCol] == 1){
                    q.offer(new Pair(newRow,newCol));
                    grid[newRow][newCol] = 0;
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    int cnt = bfs(new Pair(i,j),grid);
                    max = Math.max(max,cnt);
                }
            }
        }
        return max;
    }
}