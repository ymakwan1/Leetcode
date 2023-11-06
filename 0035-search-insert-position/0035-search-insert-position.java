class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = -1;
        int high = nums.length;

        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target){
                high = mid;
            }else{
                low = mid;
            }
        }
        return high;
    }
}