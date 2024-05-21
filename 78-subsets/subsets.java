import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList)); // Add the current subset to the result list
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]); // Include the current element
            backtrack(result, tempList, nums, i + 1); // Recurse with the current element included
            tempList.remove(tempList.size() - 1); // Exclude the current element and backtrack
        }
    }
}
