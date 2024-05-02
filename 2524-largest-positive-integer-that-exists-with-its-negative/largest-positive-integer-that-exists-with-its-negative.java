class Solution {
    public int findMaxK(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int start = 0;
        int end = n - 1;

        while(start < end){
            if(nums[start] == (nums[end]*(-1))){
                return nums[end];
            } else if(nums[end] > (nums[start] * (-1))){
                end--;
            }else{
                start++;
            }
        }
        
        return -1;
    }
}