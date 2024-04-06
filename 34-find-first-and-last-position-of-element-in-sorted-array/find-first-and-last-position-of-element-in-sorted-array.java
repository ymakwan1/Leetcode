class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstOcc(nums, target);
        int last = lastOcc(nums, target);
        return new int[]{first, last};
    }

    private int lastOcc(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int res = -1;
        while(low<=high){
            int mid = low + (high - low) / 2;
            //System.out.println(mid);
            if(nums[mid] == target){
                res = mid;
                low = mid + 1;
            }
            if(nums[mid] > target){
                high = mid - 1;   
            }else {
                low = mid + 1;
            }
        }
        return res;
    }

    private int firstOcc(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int res = -1;
        while(low<=high){
            int mid = low + (high - low) / 2;
            //System.out.println(mid);
            if(nums[mid] == target){
                res = mid;
                high = mid - 1;
            }
            if(nums[mid] < target){
                low = mid + 1; 
            }else {
                high = mid - 1; 
            }
        }
        return res;
    }
}