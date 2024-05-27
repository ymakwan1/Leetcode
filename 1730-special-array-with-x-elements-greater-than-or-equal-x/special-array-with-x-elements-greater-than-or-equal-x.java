class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return -1;
        }

        Arrays.sort(nums);

        for(int i = 0; i <= n; i++){
            int count = n - lowerBound(nums, i);
            if(count == i){
                return i;
            }
        }

        return -1;
    }

    private int lowerBound(int[] nums, int i){
        int left = 0; int right = nums.length - 1;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] >= i){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}