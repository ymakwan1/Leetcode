class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for(int start = 0; start < nums.length; start++){
            if(set.contains(nums[start])){
                return true;
            }
            set.add(nums[start]);

            if(set.size() > k){
                set.remove(nums[start - k]);
            }
        }
        
        return false;
    }
}