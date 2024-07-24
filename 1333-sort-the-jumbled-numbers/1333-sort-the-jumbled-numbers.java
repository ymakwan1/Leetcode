import java.util.*;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // list of pairs (translated value, original index)
        List<int[]> translatedNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            translatedNums.add(new int[]{translate(nums[i], mapping), i});
        }

        // sort the translated values with their original indexes
        Collections.sort(translatedNums, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // Maintain original order if translated values are the same
            }
            return a[0] - b[0];
        });

        // Extract the sorted original numbers based on the sorted translated values
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < translatedNums.size(); i++) {
            sortedNums[i] = nums[translatedNums.get(i)[1]];
        }

        return sortedNums;
    }

    private int translate(int num, int[] mapping) {
        if (num == 0) {
            return mapping[0];
        }
        
        int result = 0;
        int multiplier = 1;

        while (num > 0) {
            int digit = num % 10;
            result = mapping[digit] * multiplier + result;
            num /= 10;
            multiplier *= 10;
        }

        return result;
    }
}
