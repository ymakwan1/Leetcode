class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low+high)/2;
            
            int count = 0;

            for(int i : nums){
                if(i <= mid){
                    count++;
                }
            }

            if(count > mid){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}