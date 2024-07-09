class Solution {
    public double averageWaitingTime(int[][] customers) {
        long totalWaitTime = 0;
        long currentTime = 0;

        for (int[] customer : customers) {
            currentTime = currentTime > customer[0] ? currentTime : customer[0];
            totalWaitTime += (currentTime - customer[0]) + customer[1];
            currentTime += customer[1];
        }

        return (double) totalWaitTime / customers.length;
    }
}
