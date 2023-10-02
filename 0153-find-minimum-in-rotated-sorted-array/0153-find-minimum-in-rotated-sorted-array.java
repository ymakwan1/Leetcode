class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int middle;
        
        while(start < end){
            middle = (start + end) / 2;
            
            if(nums[start] < nums[end]){
                return nums[start];
            } else if (middle > 0 && nums[middle] < nums[middle - 1]){
                return nums[middle];
            }
            if (nums[middle] < nums[end]) {
                end = middle - 1;
            }else {
                start = middle + 1;
            }
        }
        return nums[start];
    }
}