class Solution {
    static class Meeting{
        int startTime, endTime, meetingId;
        Meeting(int startTimeIn, int endTimeIn, int meetingIdIn){
            startTime = startTimeIn;
            endTime = endTimeIn;
            meetingId = meetingIdIn;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        
        Meeting[] meeting = new Meeting[n];
        for(int i = 0; i < n; i++){
            meeting[i] = new Meeting(intervals[i][0], intervals[i][1], i+1);
        }
        Arrays.sort(meeting, (a, b) -> a.endTime - b.endTime);

        int count = 1, freeTime = meeting[0].endTime;
        
        for(int i = 1; i < n; i++){
            if(meeting[i].startTime >= freeTime){
                count++;
                freeTime = meeting[i].endTime;
            }
        }

        return n - count;
    }
}