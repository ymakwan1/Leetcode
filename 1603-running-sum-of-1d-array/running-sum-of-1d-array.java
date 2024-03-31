class Solution {
    public int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        int s = 0;
        for (int j = 0; j < sum.length; j++) {
            s += nums[j];
            sum[j] = s;
        }
        return sum;
    }
}