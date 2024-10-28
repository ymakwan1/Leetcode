import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums); // Sort for ordered processing
        HashSet<Integer> numSet = new HashSet<>();
        
        for (int num : nums) {
            numSet.add(num);
        }

        int maxStreak = 0;

        for (int num : nums) {
            int streak = 0;
            int current = num;

            // Continue the streak while each squared value is in numSet
            while (numSet.contains(current)) {
                streak++;
                numSet.remove(current); // Remove to avoid recounting in another streak
                current = current * current;

                // Break on overflow as current might become too large
                
            }
            maxStreak = Math.max(maxStreak, streak);
        }

        return maxStreak >= 2 ? maxStreak : -1; // If no streak longer than 1, return -1
    }
}
