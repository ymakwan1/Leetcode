class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Calculate the product of all elements to the left of each element
        int[] leftProducts = new int[n];
        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }
        
        // Calculate the product of all elements to the right of each element
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = leftProducts[i] * rightProduct;
            rightProduct *= nums[i];
        }
        
        return answer;
    }
}