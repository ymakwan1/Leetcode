class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int n = candidates.length;

        subSum(0, candidates, n, result, current, target);
        return result;
    }

    private void subSum(int index, int[] candidates, int n, List<List<Integer>> result, List<Integer> current,int target){
        if(index == n){
            if(target == 0){
                result.add(new ArrayList<>(current));
            }
            return;
        }

        if(candidates[index] <= target){
            current.add(candidates[index]);
            subSum(index, candidates, n, result, current, target - candidates[index]);
            current.remove(current.size() - 1);
        }
        subSum(index + 1, candidates, n, result, current, target);
    }
}