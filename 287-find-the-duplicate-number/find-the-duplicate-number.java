class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        int slow = 0;
        int fast = 1;

        while(fast < nums.length){
            if(nums[slow] == nums[fast]){
                return nums[slow];
            }
            slow++;
            fast++;
        }
        return -1;
    }
}