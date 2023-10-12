class Solution {
    public boolean canJump(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            if(nums[start] != 0){
                start += nums[start];
                if(start >= end){
                    return true;
                }
            } else{
                int i = start - 1;
                while(i >=0 && nums[i] <= (start - i)){
                    i--;
                }
                if(i < 0)
                    return false;
                
                start = i;
            }
        }
        return true;
    }
}