class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if(n == 0){
            return 0;
        }

        //Sort the array
        Arrays.sort(nums);

        //Initialize counters
        int count = 1;
        int seqCount = 1;

        for(int i = 0; i < n -1; i++){
            // Check if i+1 index is i index + 1
            if(nums[i+1] == (nums[i] + 1)){
                count++;
            }else if(nums[i+1] == nums[i]){
                //if same then continue;
                continue;
            }else{
                // or else set back to 1
                count = 1;
            }
            seqCount = Math.max(seqCount, count);
        }

        return seqCount;
    }
}