class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        boolean[] results = new boolean[m];

        int[] parity = new int[n];
        for(int i = 0; i < n; i++){
            parity[i] = nums[i] % 2;
        }

        boolean[] valid = new boolean[n - 1];
        for (int i = 0; i < n - 1; i++) {
            valid[i] = (parity[i] != parity[i + 1]);
        }

        int[] prefixValidCount = new int[n];
        for (int i = 1; i < n; i++) {
            prefixValidCount[i] = prefixValidCount[i - 1] + (valid[i - 1] ? 1 : 0);
        }

        for (int q = 0; q < m; q++) {
            int from = queries[q][0];
            int to = queries[q][1];
            
            if (to - from == 0) {
                results[q] = true;
            } else {
                int validCount = prefixValidCount[to] - prefixValidCount[from];
                results[q] = (validCount == (to - from));
            }
        }

        return results;
    }
}