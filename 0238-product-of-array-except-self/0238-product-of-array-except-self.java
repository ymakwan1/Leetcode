class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] leftProd = new int[n];
        int[] rightProd = new int[n];

        int leftProdVal = 1;
        int rightProdVal = 1;

        int[] output = new int[n];

        for(int i = 0; i < n; i++){
            leftProd[i] = leftProdVal;
            leftProdVal *= nums[i];
        }

        for(int i = n-1; i >= 0; i--){
            rightProd[i] = rightProdVal;
            rightProdVal *= nums[i];
        }

        for(int i = 0; i < n; i++){
            output[i] = leftProd[i] * rightProd[i];
        }

        return output;
    }
}