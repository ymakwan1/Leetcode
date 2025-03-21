class Solution {
    public int minMoves(int[] nums) {
        //Better
        // Arrays.sort(nums);
        // int moves = 0;
        // for(int i = 1; i < nums.length; i++){
        //     moves += (nums[i] - nums[0]);
        // }
        // return moves;

        //Optimal
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int n : nums){
            sum += n;
            min = Math.min(min, n);
        }
        return sum - (min * nums.length);
    }
}