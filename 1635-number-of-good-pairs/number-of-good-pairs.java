class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        for(int n : nums){
            count[n]++;
        }

        int totalCount = 0;
        for(int c : count){
            totalCount += (c*(c-1))/2;
        }
        
        return totalCount;
    }
}