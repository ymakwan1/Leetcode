class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int n = nums.length;
        int l = 0, r = 0, zeros = 0;

        //Brute
        // for(int i = 0; i < n; i++){
        //     int zeros = 0;
        //     for(int j = i; j < n; j++){
        //         if(nums[j] == 0){
        //             zeros++;
        //         }
        //         if(zeros <= k){
        //             maxLen = Math.max(j - i + 1, maxLen);
        //         }else{
        //             break;
        //         }
        //     }
        // }
        // return maxLen;

        //Better
        // while(r < n){
        //     if(nums[r] == 0){
        //         zeros++;
        //     }

        //     while(zeros > k){
        //         if(nums[l] == 0){
        //             zeros--;
        //         }
        //         l++;
        //     }

        //     if(zeros <= k){
        //         maxLen = Math.max(r - l + 1, maxLen);
        //     }
        //     r++;
        // }
        // return maxLen;

        //Optimal
        while(r < n){
            if(nums[r] == 0){
                zeros++;
            }

            if(zeros > k){
                if(nums[l] == 0){
                    zeros--;
                }
                l++;
            }

            if(zeros <= k){
                maxLen = Math.max(r - l + 1, maxLen);
            }
            r++;
        }
        return maxLen;
    }
}