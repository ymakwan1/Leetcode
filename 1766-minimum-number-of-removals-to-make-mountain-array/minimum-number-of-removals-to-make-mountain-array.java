class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        //Increasing sequence
        int[] increasing = new int[n];
        for(int i = 0; i < n; i++){
            increasing[i] = 1; //every elem can be subseq of 1 atleast
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    increasing[i] = Math.max(increasing[i], increasing[j] + 1);
                }
            }
        }
        
        //decreasing sequence
        int[] decreasing = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            decreasing[i] = 1; //every elem can be subseq of 1 atleast
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    decreasing[i] = Math.max(decreasing[i], decreasing[j] + 1);
                }
            }
        }

        int maxMountainLength = 0;
        for(int i = 0; i < n; i++){
            if(increasing[i] > 1 && decreasing[i] > 1){
                int mountainLength = increasing[i] + decreasing[i] - 1;
                maxMountainLength = Math.max(maxMountainLength, mountainLength);
            }
        }

        return n - maxMountainLength;
    }
}