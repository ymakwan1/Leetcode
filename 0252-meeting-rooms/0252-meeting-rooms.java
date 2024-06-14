class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        for(int i = 1; i < n; i++){
            if(intervals[i][0] < intervals[i-1][1]){
                return false;  
            }
        }

        return true;
    }
}