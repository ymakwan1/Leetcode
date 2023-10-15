class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int diffA = a[0] - a[1];
                int diffB = b[0] - b[1];
                return Integer.compare(diffA, diffB);
            }
        });

        int sum = 0;
        for(int i = 0; i < costs.length/2; i++){
            sum += costs[i][0];
        }
        for(int i = costs.length/2; i < costs.length; i++){
            sum += costs[i][1];
        }
        // System.out.println(sum);
        // Print the sorted array
        // for (int[] row : costs) {
        //     System.out.println(Arrays.toString(row));
        // }
        return sum;
    }
}