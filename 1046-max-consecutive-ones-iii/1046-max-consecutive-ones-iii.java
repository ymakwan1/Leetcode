class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int n = nums.length;

        //Brute
        for(int i = 0; i < n; i++){
            int zeros = 0;
            for(int j = i; j < n; j++){
                if(nums[j] == 0){
                    zeros++;
                }
                if(zeros <= k){
                    maxLen = Math.max(j - i + 1, maxLen);
                }else{
                    break;
                }
            }
        }
        return maxLen;
    }
}