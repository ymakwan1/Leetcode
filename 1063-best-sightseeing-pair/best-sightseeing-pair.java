class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = values[0];
        int result = Integer.MIN_VALUE;

        for(int j = 1; j < values.length; j++){
            result = Math.max(result, maxScore + values[j] - j);
            maxScore = Math.max(maxScore, values[j] + j);
        }

        return result;
    }
}