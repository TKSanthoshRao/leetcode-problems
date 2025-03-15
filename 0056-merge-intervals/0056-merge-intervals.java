class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0;i<intervals.length;i++){
           int start = intervals[i][0];
           int end = intervals[i][1];
            if(!list.isEmpty() && end <= list.get(list.size() - 1).get(1)){
                continue;
            }

           for(int j = i+1;j<intervals.length;j++){
            if(intervals[j][0]<=end){
                end = Math.max(end,intervals[j][1]);
            }else{
                break;
            }
           }
           list.add(new ArrayList<>(Arrays.asList(start,end)));
        }

         int rows = list.size();
        int cols = list.get(0).size();

        int[][] array = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = list.get(i).get(j);
            }
        }

        return array;
    }
}