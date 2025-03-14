class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result;

        //Brute
        // HashSet<List<Integer>> set = new HashSet<>();
        // for(int i = 0; i < n; i++){
        //     for(int j = i+1; j < n; j++){
        //         for(int k = j+1; k < n; k++){
        //             if(nums[i] + nums[j] + nums[k] == 0){
        //                 List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 temp.sort(null);
        //                 set.add(temp);
        //             }
        //         }
        //     }
        // }
        // result = new ArrayList<>(set);

        //Better
        HashSet<List<Integer>> set = new HashSet<>();
        HashSet<Integer> st = new HashSet<>();
        for(int i = 0; i < n; i++){
            st = new HashSet<>();
            for(int j = i+1; j < n; j++){
                int k = -(nums[i] + nums[j]);
                if(st.contains(k)){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], k);
                    temp.sort(null);
                    set.add(temp);
                }
                st.add(nums[j]);
            }
        }
        result = new ArrayList<>(set);
        return result;
    }
}