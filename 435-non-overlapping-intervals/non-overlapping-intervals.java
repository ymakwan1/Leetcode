class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1, freeTime = intervals[0][1];
        
        for(int i = 1; i < n; i++){
            if(intervals[i][0] >= freeTime){
                count++;
                freeTime = intervals[i][1];
            }
        }

        return n - count;
    }
}