class Solution {
    public int minPatches(int[] nums, int n) {
        int index = 0;
        int patches = 0;
        long miss = 1;

        while (miss <= n) {
            if (index < nums.length && nums[index] <= miss) {
                miss = miss + nums[index];
                index++;
            }else{
                miss = miss + miss;
                patches++;
            }
        }

        return patches;
    }
}