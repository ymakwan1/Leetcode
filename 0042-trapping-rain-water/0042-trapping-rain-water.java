class Solution {
    public int trap(int[] height) {
        //Better
        // int n = height.length;
        // int total = 0, leftMax = 0, rightMax = 0;
        // int[] suffix = new int[n];
        // int[] prefix = new int[n];

        // prefix[0] = height[0];
        // suffix[n-1] = height[n-1];

        // for(int i = 1; i < n; i++){
        //     prefix[i] = Math.max(prefix[i-1], height[i]);
        // }
        // for(int i = n-2; i >= 0; i--){
        //     suffix[i] = Math.max(suffix[i+1], height[i]);
        // }

        // for(int i = 0; i < n; i++){
        //     leftMax = prefix[i];
        //     rightMax = suffix[i];
        //     if(height[i] < leftMax && height[i] < rightMax){
        //         total += Math.min(leftMax, rightMax) - height[i];
        //     }
        // }

        // return total;

        //Optimal
        int left = 0;
        int right = height.length - 1;
        int water = 0, leftMax = 0, rightMax = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }else{
                    water += leftMax - height[left];
                }
                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }
}