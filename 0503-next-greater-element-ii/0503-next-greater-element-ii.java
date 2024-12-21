class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Arrays.fill(nge, -1);

        for(int i = 0; i <= n - 1; i++){
            for(int j = i + 1; j <= i + n - 1; j++){
                int index = j % n;
                if(nums[index] > nums[i]){
                    nge[i] = nums[index];
                    break;
                }
            }
        }

        return nge;
    }
}