import java.util.*;

public class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            boolean isSorted = true;
            int maxElement = nums[i];
            
            //Check if the subarray is sorted and consecutive
            for (int j = i; j < i + k - 1; j++) {
                if (nums[j] + 1 != nums[j + 1]) {
                    isSorted = false;
                    break;
                }
                maxElement = Math.max(maxElement, nums[j + 1]);
            }
            
            // Assign the power
            results[i] = isSorted ? maxElement : -1;
        }
        
        return results;
    }
}
