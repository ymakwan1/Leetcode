class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i = 0; i < n; i++){
           // min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        int check;
        int low = 1;
        int high = max;
        while(low <= high){
            int mid = (low+high)/2;
            check = sumCalc(nums, mid);
            if(check<=threshold){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        // for(int i = 1; i <= max; i++){
        //     check = sumCalc(nums, i);
        //     // System.out.println("Sum: "+ check+" Pos: "+i);
        //     if(check<=threshold){
        //         return i;
        //     }
        // }
        // for(int i = 0; i < n; i++){
        //     check = sumCalc(nums, nums[i]);
        //     if(check<=threshold){
        //         return i;
        //     }
        // }
        return low;
    }

    private int sumCalc(int[] nums, int pos){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            int c = (int)(Math.ceil((double)(nums[i])/pos));
            // System.out.println(c);
            sum += c;
            //System.out.println(sum);
        }
        //System.out.println("Sum: "+ sum+" Pos: "+pos);
        return sum;
    }
}