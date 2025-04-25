class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int changes[] = new int[1001];

        for (int[] trip : trips) {
            int passengers = trip[0], start = trip[1], end = trip[2];

            changes[start] += passengers;
            changes[end] -= passengers;
        }

        int currentPassengers = 0;
        for (int i = 0; i < changes.length; i++) {
            currentPassengers += changes[i];
            if (currentPassengers > capacity) {
                return false;
            }
        }

        return true;
    }
}