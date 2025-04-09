class Solution {
    public void dfs(int r,int c,boolean[][] visited, char[][] board){
        int row[] = {-1,0,0,+1};
        int col[] = {0,-1,+1,0};
        int m  = board.length,n = board[0].length;
        if(board[r][c] == 'O'){
            visited[r][c] = true;
            for(int i = 0;i<4;i++){
                int newRow = r + row[i];
                int newCol = c + col[i];
                if(newRow<m && newRow>=0 && newCol<n && newCol>=0 && !visited[newRow][newCol]){
                    dfs(newRow,newCol,visited,board);
                }
            }
        }


    }
    public void solve(char[][] board) {
        int m = board.length,n = board[0].length;
        boolean visited[][] = new boolean[board.length][board[0].length];
        for(int i = 0;i<n;i++){
            if(!visited[0][i]){
                dfs(0,i,visited,board);
            }
        }
        for(int i = 0;i<m;i++){
            if(!visited[i][n-1]){
                dfs(i,n-1,visited,board);
            }
        }
         for(int i = 0;i<n;i++){
            if(!visited[m-1][i]){
                dfs(m-1,i,visited,board);
            }
        }
        for(int i = 0;i<m;i++){
            if(!visited[i][0]){
                dfs(i,0,visited,board);
            }
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(!visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}