class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();

        while(left < right){
            int mid = (left + right) / 2;
            if(canSplit(nums, mid,maxOperations)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    public static boolean canSplit(int[] nums, int maxLimit,int maxOperations){
        int ops = 0;
        for(int num : nums){
            if(num > maxLimit){
                ops += (num - 1) / maxLimit;
            }
            if(ops > maxOperations){
                return false;
            }
        }

        return true;
    }
}