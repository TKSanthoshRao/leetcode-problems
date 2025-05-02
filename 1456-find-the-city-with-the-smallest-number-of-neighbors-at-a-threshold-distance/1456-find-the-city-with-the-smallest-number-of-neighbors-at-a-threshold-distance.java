class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int mat[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            mat[edges[i][0]][edges[i][1]] = edges[i][2];
            mat[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][k] != Integer.MAX_VALUE && mat[k][j] != Integer.MAX_VALUE) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                    }
                }
            }
        }
        int res[] = new int[n];
        //int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && mat[i][j] <= distanceThreshold) {
                    res[i]++;
                }
            }
        }
        int min = Integer.MAX_VALUE,sol = -1;
        for (int i = 0; i < n; i++) {
            if(res[i]<=min){
                min = res[i];
                sol = i;
            }
        }
        return sol;

    }
}