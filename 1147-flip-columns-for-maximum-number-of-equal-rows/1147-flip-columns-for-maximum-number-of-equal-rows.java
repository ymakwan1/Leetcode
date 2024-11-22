class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> patternCount = new HashMap<>();
        int maxRows = 0;

        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            StringBuilder complement = new StringBuilder();

            for (int value : row) {
                pattern.append(value); 
                complement.append(value ^ 1);
            }

            //Count the pattern or its complement
            String patternStr = pattern.toString();
            patternCount.put(patternStr, patternCount.getOrDefault(patternStr, 0) + 1);

            String complementStr = complement.toString();
            patternCount.put(complementStr, patternCount.getOrDefault(complementStr, 0) + 1);

            //Update the maximum count
            maxRows = Math.max(maxRows, Math.max(patternCount.get(patternStr), patternCount.get(complementStr)));
        }

        return maxRows;
    }
}