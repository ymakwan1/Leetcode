class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);

        int count = 1;
        int seq = 1;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i+1] == nums[i]+1){
                count++;
            } else if(nums[i] == nums[i+1]){
                continue;
            } else {
                count = 1;
            }

            seq = Math.max(seq,count);
        }
        return seq;
    }
}