class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];

        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        Integer[] cities = new Integer[n];
        for (int i = 0; i < cities.length; i++) {
            cities[i] = i;
        }
        Arrays.sort(cities, (a,b) -> degree[b]-degree[a]);

        long[] importance = new long[n];
        for (int i = 0; i < n; i++) {
            importance[cities[i]] = n-i;
        }

        long totalImportance = 0;
        for (int[] road: roads) {
            totalImportance += importance[road[0]] + importance[road[1]];
        }
        
        return totalImportance;
    }
}