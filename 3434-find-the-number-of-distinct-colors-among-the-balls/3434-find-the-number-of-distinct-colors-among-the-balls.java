class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballToColor = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();
        Set<Integer> colorSet = new HashSet<>();
        
        int n = queries.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            // Remove old color if exists
            if (ballToColor.containsKey(ball)) {
                int oldColor = ballToColor.get(ball);
                colorCount.put(oldColor, colorCount.get(oldColor) - 1);
                if (colorCount.get(oldColor) == 0) {
                    colorSet.remove(oldColor);
                }
            }

            // Assign new color
            ballToColor.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            colorSet.add(color);

            // Store the count of distinct colors
            result[i] = colorSet.size();
        }
        return result;
    }
}