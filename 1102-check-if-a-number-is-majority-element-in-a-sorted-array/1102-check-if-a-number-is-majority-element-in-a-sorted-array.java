class Solution {
    public int findFirstOccurrence(int[] nums, int target) {
        int lo = -1, hi = nums.length;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isGreaterOrEqual(nums[mid], target)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (hi == nums.length || nums[hi] != target) {
            return -1;
        }
        return hi;
    }

    public int findLastOccurrence(int[] nums, int target) {
        int lo = -1, hi = nums.length;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isSmallerOrEqual(nums[mid], target)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        if (lo == -1 || nums[lo] != target) {
            return -1;
        }
        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = findFirstOccurrence(nums, target);
        int last = findLastOccurrence(nums, target);
        return new int[]{first, last};
    }

    private boolean isGreaterOrEqual(int a, int b) {
        return a >= b;
    }

    private boolean isSmallerOrEqual(int a, int b) {
        return a <= b;
    }
    public boolean isMajorityElement(int[] nums, int target) {
        int[] range = searchRange(nums, target);
        if(range[0] == -1){
            return false;
        }

        int length = range[1] + 1 - range[0];

        return length > (nums.length/2);
    }
}