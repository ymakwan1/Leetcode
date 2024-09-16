class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) {
            return 0;  
        }
        
        // Convert all time points to minutes
        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            String[] t = time.split(":");
            int hours = Integer.parseInt(t[0]);
            int mins = Integer.parseInt(t[1]);
            minutes.add(hours * 60 + mins);
        }
        
        // Sort the list of time in minutes
        Collections.sort(minutes);
        
        // Initialize minDiff with a large value
        int minDiff = Integer.MAX_VALUE;
        
        // Calculate the differences between consecutive times
        for (int i = 1; i < minutes.size(); i++) {
            minDiff = Math.min(minDiff, minutes.get(i) - minutes.get(i - 1));
        }
        
        // Check the circular difference 
        int circularDiff = 1440 + minutes.get(0) - minutes.get(minutes.size() - 1);
        minDiff = Math.min(minDiff, circularDiff);
        
        return minDiff;
    }
}
