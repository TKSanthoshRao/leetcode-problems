class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> h = new HashSet<>();
        int arr[] = new int[2];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
            if(!h.contains(grid[i][j])){
                h.add(grid[i][j]);
            }else{
                arr[0] = grid[i][j];
            }
            }
        }
        int sqre = grid.length*grid.length;
        for(int i =  1;i<=sqre;i++){
            if(!h.contains(i)){
                arr[1] = i;
                break;
            }
        }
        return arr;
    }
}