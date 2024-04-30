class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       int n = nums.length;
       
       Set<List<Integer>> st = new HashSet<>();
       Arrays.sort(nums);

       for(int i = 0; i < n; i++){
            Set<Integer> hashset = new HashSet<>();
            for(int j = i+1; j < n; j++){
                int k = -(nums[i]+nums[j]);
                if(hashset.contains(k)){
                    st.add(Arrays.asList(nums[i], nums[j], k));
                }
                hashset.add(nums[j]);
            }
        }
        List<List<Integer>> result = new ArrayList<>(st);
        return result;
    }
}