class Solution {
    public int search(int[] nums, int target) {
        //Brute  - linear search
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == target) {
        //         return i ;
        //     }
        // }
        // return -1;

        // Better - binary search

        int left = 0, right  = nums.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            
            if(nums[mid] == target) return mid;

            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            else{
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}