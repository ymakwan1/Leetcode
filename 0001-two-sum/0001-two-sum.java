class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> twoSumArrayList = new ArrayList<Integer>();
        for(int i = 0 ; i < nums.length ; i++){
            for (int j = i + 1 ; j < nums.length ; j++){
                if(nums[i]+nums[j] == target) {
                    twoSumArrayList.add(i);
                    twoSumArrayList.add(j);
                }
            }
        }
        int[] twoSumArray = twoSumArrayList.stream().mapToInt(Integer::intValue).toArray();
        return twoSumArray;
    }
}