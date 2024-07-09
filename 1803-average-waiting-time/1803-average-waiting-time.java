class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double totalWaitTime = 0.0;
        double currentTime = 0;

        for(int[] c : customers){
            currentTime = Math.max(currentTime, c[0]);
            totalWaitTime += ((currentTime - c[0]) + c[1]);
            currentTime += c[1];
        }

        return (double)(totalWaitTime / n);
    }
}