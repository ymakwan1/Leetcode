class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> res = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]> (){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

        for(int i = 0; i < n; i++){
            if(res.isEmpty() || intervals[i][0] > res.get(res.size()-1).get(1)){
                res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }else {
                res.get(res.size() - 1).set(1, Math.max(res.get(res.size()-1).get(1), intervals[i][1]));
            }
        }

        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i][0] = res.get(i).get(0);
            result[i][1] = res.get(i).get(1);
        }

        return result;
    }
}