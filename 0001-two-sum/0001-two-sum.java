class Solution {
    public int[] twoSum(int[] nums, int target) {
        int a=0;int b=0;
        for(int i=0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(target == nums[i]+nums[j]){
                    a = i;b=j;
                }
            }
        }
        return new int[]{a,b};
    }
}