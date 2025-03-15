class Solution {
    public int [][] bruteForce(int[][] intervals){
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


    public int[][] optimal(int[][] intervals){
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i = 0;i<intervals.length;i++){
            if(arr.isEmpty()){
                arr.add(new ArrayList<>(Arrays.asList(intervals[i][0],intervals[i][1])));
                continue;
            }
            if(intervals[i][0]<=arr.get(arr.size()-1).get(1)){
                arr.get(arr.size()-1).set(1,Math.max(intervals[i][1],arr.get(arr.size()-1).get(1)));
            }else{
                 arr.add(new ArrayList<>(Arrays.asList(intervals[i][0],intervals[i][1])));
            }
        }
 int rows = arr.size();
        int cols = arr.get(0).size();

        int[][] array = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = arr.get(i).get(j);
            }
        }

        return array;

    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //return bruteForce(intervals);
         return optimal(intervals);
    }
}