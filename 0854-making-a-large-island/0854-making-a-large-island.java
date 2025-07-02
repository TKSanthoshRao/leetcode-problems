class Dsu{
    int par[];
    int size[];
    public Dsu(int n){
        par = new int[n*n];
        size = new int[n*n];
        for(int i = 0;i<n*n;i++){
            par[i] = i;
            size[i] = 1;
        }
    }
    public int findPar(int n){
        if(par[n] == n) return n;
        return par[n] = findPar(par[n]);
    }
    public void union(int u,int v){
        int parU = findPar(u);
        int parV = findPar(v);
        if(parU == parV) return;
        if(size[parU]<size[parV]){
            par[parU] = parV;
            size[parV]+=size[parU];
        }
        else{
            par[parV] = parU;
            size[parU]+=size[parV];
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        //int ngrid[][] = new int[grid.length][grid.length];
        Dsu ds = new Dsu(grid.length);
        int row[] = {0,0,-1,+1};
        int col[] = {-1,+1,0,0};
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid.length;j++){
                if(grid[i][j] == 0) continue;
                for(int k = 0;k<4;k++){
                    int nr = i+row[k];
                    int nc = j+col[k];
                        if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc] == 1)
                            ds.union(i*n+j,nr*n+nc);
                }
            }
        }
        int max = 0;
        // HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1) continue;
                HashSet<Integer> hs = new HashSet<>();
                int area = 1;
                    for(int k = 0;k<4;k++){
                               int nr = i+row[k];
                               int nc = j+col[k];
                        if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc] == 1){
                                int parent = ds.findPar(nr*n+nc);
                                        if (hs.add(parent)) { 
                                          area += ds.size[parent];
                                        }
                        }
                    }
                        max = Math.max(max,area);
            }
        }
        if(max == 0) return n*n;
        return max;
    }
}