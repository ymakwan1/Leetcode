class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;

        for(int i = 0; i < nums.length; i++){
            //Left boundary where nums[i]+nums[j] >= lower
            int left = binarySearchLeft(nums, i + 1, nums.length - 1, lower - nums[i]);

            //Left boundary where nums[i]+nums[j] <= upper
            int right = binarySearchRight(nums, i + 1, nums.length - 1, upper - nums[i]);

            if(left != -1 && right != -1 && left <= right){
                count += (right - left + 1);
            }
        }

        return count;
    }

    //Search to find first index where nums[i]+nums[j] >= lower
    private int binarySearchLeft(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return start < nums.length ? start : -1;
    }

    //Search to find first index where nums[i]+nums[j] <= upper
    private int binarySearchRight(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return end >= 0 ? end : -1;
    }    
}