class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        int low = 1;
        int high = max;
        while(low <= high){
            int mid = (low + high) / 2;
            int reqTime = totalHours(piles, mid);
            if(reqTime <= h){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int totalHours(int[] nums, int k){
        int totalH = 0;
        for(int i = 0; i < nums.length; i++){
            totalH += Math.ceil((double)(nums[i])/(double)(k));
        }
        return totalH;
    }
}