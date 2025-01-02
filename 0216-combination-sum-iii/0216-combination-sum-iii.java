class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        findCombinations(1, k, n, current, result);
        return result;
    }

    private void findCombinations(int start, int k, int target, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            if (target == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > target){
                break;
            }
            
            current.add(i);
            findCombinations(i + 1, k, target - i, current, result);
            current.remove(current.size() - 1);
        }
    }
}