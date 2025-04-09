class Pair{
    int x,y,d;
    public Pair(int x,int y,int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
class Solution {
    public int[][] bfs(int[][] mat){
        int m = mat.length,n = mat[0].length;
        boolean visited[][] = new boolean[m][n];
        int newMat[][] = new int[m][n];
        Queue<Pair> q = new LinkedList<Pair>();
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 0){
                    newMat[i][j] = 0;
                    visited[i][j] = true;
                    q.offer(new Pair(i,j,0));
                }
            }
        }
        int row[] = {-1,+1,0,0};
        int col[] = {0,0,+1,-1};
        while(!q.isEmpty()){
            Pair node = q.poll();
            for(int i = 0;i<4;i++){
                int newRow = row[i]+node.x;
                int newCol = col[i]+node.y;
                if(newRow<m && newRow>=0 && newCol<n && newCol>=0 && !visited[newRow][newCol]){
                    newMat[newRow][newCol] = node.d+1;
                    visited[newRow][newCol] = true;
                    q.offer(new Pair(newRow,newCol,node.d+1));

                }
            }
        }
        return newMat;
    }
    public int[][] updateMatrix(int[][] mat) {
        return bfs(mat);
    }
}