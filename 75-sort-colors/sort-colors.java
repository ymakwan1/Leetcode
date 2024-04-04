class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        
        // Iterate over each element in the array starting from the second one
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            
            // Move elements of array[0..i-1], that are greater than key, to one position ahead
            // of their current position
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
    }
}