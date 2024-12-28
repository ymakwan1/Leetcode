class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int n = candidates.length;
        Arrays.sort(candidates);
        subSum(0, candidates, n, result, current, target);
        return result;
    }

    private void subSum(int index, int[] candidates, int n, List<List<Integer>> result, List<Integer> current,int target){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i < n; i++){
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            current.add(candidates[i]);
            subSum(i + 1, candidates, n, result, current, target - candidates[i]);
            current.remove(current.size() - 1);
        }
    }
}