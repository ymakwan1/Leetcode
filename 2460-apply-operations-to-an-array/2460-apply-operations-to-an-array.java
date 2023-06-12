class Solution {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        for(int j = 0, zero = 0; j < nums.length; j++){
            if(nums[j] != 0){
                int temp = nums[j];
                nums[j] = 0;
                nums[zero++] = temp;
            }
        }
        return nums;
    }
}