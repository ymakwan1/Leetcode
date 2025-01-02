class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        List<Integer> current = new ArrayList<>();
        boolean[] freq = new boolean[n];
        permuteCalc(nums, n, freq, current, result);
        return result;
    }

    private void permuteCalc(int[] nums, int n, boolean[] freq, List<Integer> current, List<List<Integer>> result){
        if(current.size() == n){
            result.add(new ArrayList<>(current));
        } else{
            for(int i = 0; i < nums.length; i++){
                if (!freq[i]) {
                    freq[i] = true;
                    current.add(nums[i]);
                    permuteCalc(nums, n, freq, current, result);
                    current.remove(current.size() - 1);
                    freq[i] = false;
                }
            }
        }
    }
}