class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;

        List<int[]> valueIndexPairs = new ArrayList<>();
        for(int i = 0; i < n; i++){
            valueIndexPairs.add(new int[]{nums[i], i});
        }

        valueIndexPairs.sort((a, b) -> Integer.compare(a[0], b[0]));

        boolean[] marked = new boolean[n];
        long score = 0;

        for(int[] pair : valueIndexPairs){
            int value = pair[0];
            int index = pair[1];

            if(!marked[index]){
                score += value;
                marked[index] = true;
                if(index < n - 1){
                    marked[index + 1] = true;
                }
                if(index > 0){
                    marked[index - 1] = true;
                }
            }
        }
        return score;
    }
}