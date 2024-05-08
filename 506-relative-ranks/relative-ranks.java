import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        // Create a new array to store the ranks
        String[] result = new String[score.length];
        
        // Sort the array in descending order
        Integer[] indexes = new Integer[score.length];
        for (int i = 0; i < score.length; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, Comparator.comparingInt((Integer i) -> score[i]).reversed());
        
        // Assign ranks based on the sorted order
        for (int i = 0; i < score.length; i++) {
            int rank = i + 1;
            if (rank == 1) {
                result[indexes[i]] = "Gold Medal";
            } else if (rank == 2) {
                result[indexes[i]] = "Silver Medal";
            } else if (rank == 3) {
                result[indexes[i]] = "Bronze Medal";
            } else {
                result[indexes[i]] = String.valueOf(rank);
            }
        }

        return result;
    }
}
