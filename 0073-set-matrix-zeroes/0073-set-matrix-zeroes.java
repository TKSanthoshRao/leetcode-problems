class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n  = matrix[0].length;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int i = 0;i<row.size();i++){
            for(int r = 0;r<n;r++){
                matrix[row.get(i)][r] = 0;
            }
        }
         for(int i = 0;i<col.size();i++){
            for(int r = 0;r<m;r++){
                matrix[r][col.get(i)] = 0;
            }
        }
    }
}