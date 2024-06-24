class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0;
        int end = 0;

        while(start < nums.length){
            if(nums[start] != 0){
                nums[end] = nums[start];
                end++;
            }
            start++;
        }

        for (int i = end; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}