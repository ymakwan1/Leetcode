class Solution {
    public int jump(int[] nums) {
        // Brute
        // return helper(0, 0, nums);

        //Optimal
        int jumps = 0, l = 0, r = 0;

        while(r < nums.length - 1){
            int farthest = 0;
            for(int i = l; i <= r; i++){
                farthest = Math.max(farthest, nums[i] + i);
            }
            l = r + 1;
            r = farthest;
            jumps++;
        }

        return jumps;
    }

    public int helper(int index, int jump, int[] nums){
        if(index >= nums.length - 1){
            return jump;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[index]; i++){
            min = Math.min(min, (int)helper(index + i, jump + 1, nums));
        }

        return min;
    }
}