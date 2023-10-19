class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        generateSubsets(nums, 0, currentSubset, result);
        return result;
    }

    private static void generateSubsets(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }

        // Include the current element in the subset
        currentSubset.add(nums[index]);
        generateSubsets(nums, index + 1, currentSubset, result);

        // Exclude the current element from the subset
        currentSubset.remove(currentSubset.size() - 1);
        generateSubsets(nums, index + 1, currentSubset, result);
    }
}
    
