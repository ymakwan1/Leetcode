class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> twoSumIndices = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            int difference = target - nums[i];
            
            if(twoSumIndices.containsKey(difference)){
                return new int[]{twoSumIndices.get(difference), i};
            }
            
            twoSumIndices.put(nums[i], i);
        }
        return new int[0];
    }
}