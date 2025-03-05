class Solution {
    public void rotate(int[] nums, int k) {
        // int[] arr = new int[nums.length];
        // for(int i = 0;  i < nums.length; i++){
        //     arr[(i+k) % nums.length] = nums[i];
        // }
        // for (int i = 0; i < arr.length; i++) {
        //     nums[i] = arr[i];
        // }

        int n = nums.length;
        k = k % n;

        //last k elements in a temporary array
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }

        //remaining elements to the right
        for (int i = n - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        //store k elements
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}