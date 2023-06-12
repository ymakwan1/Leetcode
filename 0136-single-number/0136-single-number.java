class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if(countMap.get(nums[i]) == 1) {
                return nums[i];
            }
        }
        return 0;
    }
}