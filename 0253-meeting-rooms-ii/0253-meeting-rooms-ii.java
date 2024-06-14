class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;

        if(n == 0){
            return 0;
        }

        int[] start = new int[n];
        int[] end = new int[n];

        int s = 0;
        int e = 0;
        int count = 0;

        for(int i = 0; i < n; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        while(s < n){
            if(start[s] < end[e]){
                count++;
            } else{
                e++;
            }
            s++;
        }

        return count;
    }
}