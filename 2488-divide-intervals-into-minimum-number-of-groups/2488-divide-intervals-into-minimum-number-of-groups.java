class Solution {
    public int minGroups(int[][] intervals) {
        //List of events
        List<int[]> events = new ArrayList<>();

        //Start and end points of each interval to the list
        for (int[] interval : intervals) {
            events.add(new int[]{interval[0], 1});   //start of interval
            events.add(new int[]{interval[1] + 1, -1}); //end of interval
        }

        //Sort by time, in case of tie, end event comes before start event
        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; //Sort end before start if same time
            }
            return a[0] - b[0];
        });

        int activeIntervals = 0;
        int maxGroups = 0;

        // Traverse through the sorted events
        for (int[] event : events) {
            activeIntervals += event[1];  //Update active interval count
            maxGroups = Math.max(maxGroups, activeIntervals); //Track the max number of active intervals
        }

        return maxGroups;
    }
}
