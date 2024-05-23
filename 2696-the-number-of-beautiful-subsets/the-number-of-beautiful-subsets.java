class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, k, result, new ArrayList<>(), 0);
        return result.size()-1;
    }

    private void backtrack(int[] nums, int k, List<List<Integer>> result, List<Integer> tempList, int start){
        if(isBeautiful(tempList, k)){
            result.add(tempList);
        }

        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(nums, k, result, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    private boolean isBeautiful(List<Integer> subset, int k){
        for(int i = 0; i < subset.size(); i++){
            for(int j = i+1; j < subset.size(); j++){
                if (Math.abs(subset.get(i) - subset.get(j)) == k) {
                    return false;
                }
            }
        }
        return true;
    }
}