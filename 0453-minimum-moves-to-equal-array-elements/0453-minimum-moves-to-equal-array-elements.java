class Solution {
    public int minMoves(int[] nums) {
        //Better
        Arrays.sort(nums);
        int moves = 0;
        for(int i = 1; i < nums.length; i++){
            moves += (nums[i] - nums[0]);
        }
        return moves;
    }
}