class Solution {
    public int[] searchRange(int[] nums, int target) {
        // int first = firstOcc(nums, target);
        // int last = lastOcc(nums, target);
        // return new int[]{first, last};

        int first = -1, last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
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